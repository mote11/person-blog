package com.edu.cqie.service;

import com.edu.cqie.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
public interface IUserService extends IService<User> {
    //跟据用户名查询用户
    User findByUserName(String username);
    //注册用户
    void register(String username,String password,String email);
    //更新用户
    void updateUser(User user);
    //更新用户头像
    void updateAvatar(String avatarUrl);
    //修改密码
    void updatePwd(String rePwd);
}
