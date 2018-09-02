package com.example.demo.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.bean.User;
import com.example.demo.vo.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;

/**
 * Json 工具类
 */
public class JsonUtil {

    private static JsonUtil jsonUtil;
    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {

    }

    public static JsonUtil getInstance() {
        if (jsonUtil == null) {
            jsonUtil = new JsonUtil();
        }
        return jsonUtil;
    }

    public String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T objectFromJsonStr(String content, Class<T> valueType) {
        T obj = null;
        try {
            obj = mapper.readValue(content, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        User user = new User("zxb", "123456", 20, new Date(), "hello zxb");
        System.out.println(user);
        JsonResult jr = JsonResult.build(user);
        System.out.println(JsonUtil.getInstance().toJson(jr));
    }
}
