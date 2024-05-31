package com.edu.cqie.service.impl;

import com.edu.cqie.entity.User;
import com.edu.cqie.mapper.UserMapper;
import com.edu.cqie.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 跟据用户名查找用户
     * @param username
     * @return
     */
    public User findByUserName(String username){
        return userMapper.findByUserName(username);
    }

    /**
     * 注册新用户
     * @param username
     * @param password
     * @param email
     */
    public void register(String username,String password,String email){
        userMapper.register(username,password,email);
    }
}
