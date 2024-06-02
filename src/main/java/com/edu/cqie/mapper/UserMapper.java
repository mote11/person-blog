package com.edu.cqie.mapper;

import com.edu.cqie.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 跟据用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    User findByUserName(@Param("username")String username);

    /**
     * 添加新用户
     * @param username
     * @param password
     * @param email
     */
    @Insert("insert into user(username,password,email,role,create_time,update_time) values (#{username},#{password},#{email},'1',now(),now())")
    void register(@Param("username") String username,@Param("password") String password,@Param("email") String email);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where user_id=#{userId}")
    void updateUser(User user);

    /**
     * 更新用户头像
     * @param avatarUrl
     * @param id
     */
    @Update("update user set user_pic=#{avatarUrl},update_time=now() where user_id=#{id}")
    void updateAvatar(@Param("avatarUrl") String avatarUrl,@Param("id") Integer id);

    /**
     * 更新用户密码
     * @param password
     * @param id
     */
    @Update("update user set password=#{password},update_time=now() where user_id=#{id}")
    void updatePwd(@Param("password") String password, @Param("id") Integer id);
}
