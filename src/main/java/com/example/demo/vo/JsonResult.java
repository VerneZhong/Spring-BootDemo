package com.example.demo.vo;

public class JsonResult {

    private String code;
    private String msg;
    private Object data;

    public JsonResult() {
    }

    public JsonResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult build(Object data) {
        return new JsonResult("200", "ok", data);
    }

    public static JsonResult errorException(Object data) {
        return new JsonResult("500", "System error", data);
    }

}
