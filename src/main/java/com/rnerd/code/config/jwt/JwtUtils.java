package com.rnerd.code.config.jwt;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

import com.rnerd.code.config.services.UserDetailsImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;


import org.springframework.http.ResponseCookie;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtils {

    final String jwtSecret = "VGhpc0lzQVNlY3JldEZvck15QXBwbGljYXRpb25Ib3BlVGhpc0lzR29vZA==";

    final int jwtExpirationMs = 60*60*1000;

    final String jwtCookie = "access_token";

    public String getJwtFromCookies(HttpServletRequest request) throws Exception {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if(cookie==null) {
            String authCookie = request.getHeader("Auth");
            if (authCookie == null) {
                throw new JwtException("Cookie Not FOund");
            }else {
                authCookie = authCookie.split("=")[1];
                return authCookie;
            }
        }

        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateToken(userPrincipal.getUsername(), userPrincipal.getAuthorities());
        return ResponseCookie.from(jwtCookie, jwt).path("/").maxAge(60 * 60).httpOnly(true).build();
    }

    public ResponseCookie getCleanJwtCookie() {
        return ResponseCookie.from(jwtCookie, null).path("/").build();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Map<String, List<String>> claimsMap = new HashMap<>();
        claimsMap.put("auth", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return Jwts.builder()
                .setClaims(claimsMap)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

}
