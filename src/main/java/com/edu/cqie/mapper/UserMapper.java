package com.edu.cqie.mapper;

import com.edu.cqie.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Insert("insert into user(username,password,email,create_time,update_time) values (#{username},#{password},#{email},now(),now())")
    void register(@Param("username") String username,@Param("password") String password,@Param("email") String email);
}
