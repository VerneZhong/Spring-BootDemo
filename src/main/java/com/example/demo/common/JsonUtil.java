package com.example.demo.common;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Json 工具类
 */
public class JsonUtil {

    private static JsonUtil jsonUtil;

    private JsonUtil() {

    }

    public static JsonUtil getInstance() {
        if (jsonUtil == null) {
            jsonUtil = new JsonUtil();
        }
        return jsonUtil;
    }

    public String toJson(Object obj) {
        return JSONObject.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
    }
}
