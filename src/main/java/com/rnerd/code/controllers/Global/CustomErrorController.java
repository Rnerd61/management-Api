package com.rnerd.code.controllers.Global;

import com.rnerd.code.payload.response.ResponseMsg;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<Map<String, String>> handleError() {
        return new ResponseEntity<>(ResponseMsg.Msg("Error", "Page Not Found"), HttpStatus.NOT_FOUND);
    }
}
