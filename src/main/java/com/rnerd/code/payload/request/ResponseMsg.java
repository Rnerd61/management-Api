package com.rnerd.code.payload.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseMsg {

    public static Map<String, String> Msg(String msg) {
        Map<String, String> res = new HashMap<>();
        res.put("msg", msg);
        return res;
    }

    public static Map<String, String> Msg(String key, String msg) {
        Map<String, String> res = new HashMap<>();
        res.put(key, msg);
        return res;
    }

    public static Map<String, String> Msg(List<String> key, List<String> msg) {
        Map<String, String> res = new HashMap<>();
        for(int i=0; i< key.size(); i++) {
            res.put(key.get(i), msg.get(i));
        }
        return res;
    }
}
