package com.edu.cqie.controller;


import com.edu.cqie.entity.Result;
import com.edu.cqie.entity.User;
import com.edu.cqie.service.IUserService;
import com.edu.cqie.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 用户注册,后续优化：密码加密，用户名、密码和邮箱进行格式判断
     * @param username
     * @param password
     * @param email
     * @return
     */
    @PostMapping("/register")
    public Result register(String username, String password, String email){
        //判断用户是否存在
        User user = userServiceImpl.findByUserName(username);
        if(user==null){
            //不存在，直接注册
            userServiceImpl.register(username,password,email);
            return Result.success();
        }else{
            //存在，提示已占用
            return Result.error("用户已存在");
        }
    }


    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Result login(String username,String password){
        User user = userServiceImpl.findByUserName(username);
        if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
            //登录到页面中

            return Result.success();
        }else{
            return Result.error("密码或用户名错误");
        }
    }



    @PostMapping("/logout")
    public Result logout(){
        //跳转到登录页面

        //清除用户信息
        return Result.success("账号已退出");
    }
}
