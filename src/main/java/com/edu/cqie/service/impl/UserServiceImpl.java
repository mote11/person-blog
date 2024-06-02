package com.edu.cqie.service.impl;

import com.edu.cqie.entity.User;
import com.edu.cqie.mapper.UserMapper;
import com.edu.cqie.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.cqie.utils.Md5Util;
import com.edu.cqie.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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
        //加密
        String md5String = Md5Util.getMD5String(password);
        userMapper.register(username,md5String,email);
    }

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(user);
    }

    /**
     * 更新用户头像
     * @param avatarUrl
     */
    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");

        userMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePwd(String rePwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(rePwd),id);
    }
}
