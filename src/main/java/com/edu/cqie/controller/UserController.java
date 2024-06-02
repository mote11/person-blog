package com.edu.cqie.controller;


import com.edu.cqie.entity.Result;
import com.edu.cqie.entity.User;
import com.edu.cqie.service.impl.UserServiceImpl;
import com.edu.cqie.utils.JwtUtil;
import com.edu.cqie.utils.Md5Util;
import com.edu.cqie.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
@Validated
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
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password,
                           @Email String email){
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
    public Result login(@Pattern(regexp = "^\\S{5,16}$")String username,@Pattern(regexp = "^\\S{5,16}$")String password){
        User user = userServiceImpl.findByUserName(username);
        if(user==null){
            return Result.error("用户名错误");
        }
        if(user.getPassword().equals(Md5Util.getMD5String(password))){
            //登录成功
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",user.getUserId());
            claims.put("username",user.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }else{
            return Result.error("密码或用户名错误");
        }
    }


    /**
     * 用户退出登录
     * @return
     */
    @PostMapping("/logout")
    public Result logout(){
        //跳转到登录页面

        //清除用户信息
        return Result.success("账号已退出");
    }

    /**
     * 获取用户具体信息
     * @return
     */
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization")String token*/){
        //跟据用户名查询用户
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String username = (String) map.get("username");
        Map<String,Object> map = ThreadLocalUtil.get();
        String  username = (String) map.get("username");
        User user = userServiceImpl.findByUserName(username);
        return Result.success(user);
    }


//=======================================================================

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result updateUser(@RequestBody @Validated User user){
        System.out.println(user);
        userServiceImpl.updateUser(user);
        return Result.success("修改成功");
    }

    /**
     * 更新用户头像
     * @param avatarUrl
     * @return
     */
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl){
        userServiceImpl.updateAvatar(avatarUrl);
        return Result.success("更新成功");
    }


    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if(!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("参数未传递完整");
        }

        //原密码是否正确
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userServiceImpl.findByUserName(username);
        System.out.println(user);
        if (!user.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码填写错误");
        }

        //newPwd和rePwd是否一样
        if (!newPwd.equals(rePwd)){
            return Result.error("两次填写密码不一致");
        }
        //调用service完成密码更新
        userServiceImpl.updatePwd(rePwd);
        return Result.success("密码修改成功");
    }
}
