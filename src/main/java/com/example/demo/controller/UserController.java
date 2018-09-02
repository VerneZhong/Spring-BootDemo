package com.example.demo.controller;

import com.example.demo.bean.Resouroce;
import com.example.demo.bean.User;
import com.example.demo.common.JsonUtil;
import com.example.demo.model.SysUser;
import com.example.demo.service.UserService;
import com.example.demo.util.idworker.util.Sid;
import com.example.demo.vo.JsonResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 读取资源文件信息
     */
    @Autowired
    private Resouroce resouroce;

    @Autowired
    private UserService userService;
    @Autowired
    private Sid sid;


    @RequestMapping("/getUser")
    public String getUser() {
        return JsonUtil.getInstance().toJson(JsonResult.build(new User("zxb", "123456", 20, new Date(), "hello zxb")));
    }

    @RequestMapping("/getResource")
    public String getResource() {
        Resouroce bean = new Resouroce();
        // source  target
        BeanUtils.copyProperties(resouroce, bean);
        bean.setDate(new Date());
        return JsonUtil.getInstance().toJson(bean);
    }

    @RequestMapping("/saveUser")
    public JsonResult saveUser() {
        log.info("saveUser，当前时间：{}，操作人：{}", LocalDateTime.now(), "Zxb");

        SysUser user = new SysUser();
        user.setId(sid.nextShort());
        user.setUsername("zxb");
        user.setNickname("钟学斌");
        user.setPassword("123456");
        user.setAge(26);
        user.setCity("北京海淀");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return JsonResult.build(user);
    }

    @RequestMapping("/updateUser")
    public JsonResult updateUser() {
        log.info("updateUser，当前时间：{}，操作人：{}", LocalDateTime.now(), "Zxb");

        SysUser user = new SysUser();
        user.setId("1809028947RZXDD4");
        user.setAddress("北京昌平区北街家园");
        user.setSex(1);
        user.setJob(1);
        user.setProvince("北京市");
        user.setCity("北京市");
        user.setDistrict("海淀区");

        userService.updateUser(user);

        return JsonResult.build(user);
    }

    @RequestMapping("/deleteUser")
    public JsonResult deleteUser() {
        log.info("updateUser，当前时间：{}，操作人：{}", LocalDateTime.now(), "Zxb");

        SysUser user = new SysUser();
        user.setId("1001");
        userService.deleteUser(user);
        return JsonResult.build(user);
    }

    @RequestMapping("/queryUserById")
    public JsonResult queryUserById() {
        log.info("queryUserById，当前时间：{}，操作人：{}", LocalDateTime.now(), "Zxb");

        String id = "1809028947RZXDD4";
        return JsonResult.build(userService.queryUserById(id));
    }

    @RequestMapping("/queryUserInfoById")
    public JsonResult queryUserInfoById(@RequestParam String userId) {
        log.info("queryUserInfoById，当前时间：{}，操作人：{}", LocalDateTime.now(), "Zxb");

        return JsonResult.build(userService.queryUserInfoById(userId));
    }

    @RequestMapping("/queryUserList")
    public JsonResult queryUserList() {
        log.info("queryUserList，当前时间：{}，操作人：{}", LocalDateTime.now(), "Zxb");

        return JsonResult.build(userService.queryUserList());
    }

    @RequestMapping("/queryUserListByPage")
    public JsonResult queryUserListByPage(@RequestParam Integer page) {
        log.info("queryUserListByPage，当前时间：{}，操作人：{}", LocalDateTime.now(), "Zxb");
        if (page == null) {
            page = 1;
        }
        int pageSize = 10;

        SysUser user = new SysUser();

//        user.setNickname("jack");

        List<SysUser> users = userService.queryUserListPagedJqgrid(user, page, pageSize);
        return JsonResult.build(users);
    }

    @RequestMapping("/saveUserTransactional")
    public JsonResult saveUserTransactional(@RequestParam String name) {
        SysUser user = new SysUser();

        user.setId(sid.nextShort());
        user.setUsername(name);
        user.setNickname(name);
        user.setPassword("123456");
        user.setAge(24);
        user.setCity("北京海淀");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);
        return JsonResult.build("ok");
    }

}
