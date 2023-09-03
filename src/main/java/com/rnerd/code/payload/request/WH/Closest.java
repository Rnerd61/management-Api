package com.rnerd.code.payload.request.WH;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Closest {
    public Map<Character, List<Character>> zones = new HashMap<>();

    public Closest() {
        zones.put('W', Arrays.asList('W', 'N', 'S', 'E'));
        zones.put('N', Arrays.asList('N', 'W', 'E', 'S'));
        zones.put('S', Arrays.asList('S', 'W', 'E', 'N'));
        zones.put('E', Arrays.asList('E', 'N', 'S', 'W'));
    }
}
