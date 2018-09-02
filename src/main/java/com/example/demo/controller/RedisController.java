package com.example.demo.controller;

import com.example.demo.common.JsonUtil;
import com.example.demo.model.SysUser;
import com.example.demo.util.RedisUtil;
import com.example.demo.util.idworker.util.Sid;
import com.example.demo.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil strRedis;
    @Autowired
    private Sid sid;

    @RequestMapping("/setKey")
    public JsonResult test() {
        // 存储字符串
        strRedis.set("zxbkey", "hello redis by spring-boot....");


        SysUser user = new SysUser();
        user.setId(sid.nextShort());
        user.setUsername("zxb");
        user.setNickname("钟学斌");
        user.setPassword("123456");
        user.setAge(26);
        user.setCity("北京海淀");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        // 存储 Json字符串
        strRedis.set("json:user", user.toString());

        // 读取Json字符串
        SysUser u = JsonUtil.getInstance().objectFromJsonStr(strRedis.get("json:user"), SysUser.class);

        return JsonResult.build(u);
    }
}
