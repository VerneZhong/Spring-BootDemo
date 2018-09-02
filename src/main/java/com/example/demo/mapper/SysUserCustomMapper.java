package com.example.demo.mapper;

import com.example.demo.model.SysUser;
import com.example.demo.util.MyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysUserCustomMapper extends MyMapper<SysUser> {

    List<SysUser> queryUserInfoById(String id);

}