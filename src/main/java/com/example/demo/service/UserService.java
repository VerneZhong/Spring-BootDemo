package com.example.demo.service;

import com.example.demo.model.SysUser;

import java.util.List;

public interface UserService {

    void saveUser(SysUser user);

    void updateUser(SysUser user);

    void deleteUser(SysUser user);

    SysUser queryUserById(String id);

    List<SysUser> queryUserInfoById(String id);

    List<SysUser> queryUserList();

    List<SysUser> queryUserListPagedJqgrid(SysUser user, int page, int pageSize);

    void saveUserTransactional(SysUser user);
}
