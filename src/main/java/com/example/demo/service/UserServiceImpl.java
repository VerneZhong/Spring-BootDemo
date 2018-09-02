package com.example.demo.service;

import com.example.demo.mapper.SysUserCustomMapper;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.model.SysUser;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserCustomMapper customMapper;

    @Override
    public void saveUser(SysUser user) {
        sysUserMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(SysUser user) {
        sysUserMapper.deleteByPrimaryKey(user);
    }

    @Override
    public SysUser queryUserById(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> queryUserInfoById(String id) {
        return customMapper.queryUserInfoById(id);
    }

    @Override
    public List<SysUser> queryUserList() {
        return sysUserMapper.selectAll();
    }

    @Override
    public List<SysUser> queryUserListPagedJqgrid(SysUser user, int page, int pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);

        // 分页对象
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            // 增加查询条件
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        // order by 字段
        example.orderBy("registTime").desc();
        // 根据条件查询
        return sysUserMapper.selectByExample(example);
    }

    /**
     * 增加事务回滚
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void saveUserTransactional(SysUser user) {
        sysUserMapper.insert(user);

        int a = 1 / 0;

        user.setIsDelete(1);
        sysUserMapper.updateByPrimaryKeySelective(user);
    }
}
