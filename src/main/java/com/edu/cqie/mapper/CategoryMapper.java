package com.edu.cqie.mapper;

import com.edu.cqie.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 新增类别
     * @param userId
     * @param categoryName
     */
    @Insert("insert into category(category_name,user_id,update_time) values (#{categoryName},#{userId},now())")
    void addCategory(@Param("userId") Integer userId, @Param("categoryName") String categoryName);


    /**
     * 编辑类别
     * @param categoryId
     * @param categoryName
     * @param userId
     */
    @Update("update category set category_name=#{categoryName},user_id=#{userId},update_time=now() where category_id=#{categoryId}")
    void editCategory(@Param("categoryId") Integer categoryId,@Param("categoryName")String categoryName,@Param("userId")Integer userId);

    /**
     * 删除类别
     * @param categoryId
     */
    @Delete("delete from category where category_id=#{categoryId}")
    void deleteCategory(Integer categoryId);
}
