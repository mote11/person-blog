package com.edu.cqie.service;

import com.edu.cqie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
public interface ICategoryService extends IService<Category> {
    //新增类别
    void addCategory(Integer userId,String categoryName);
    //编辑类别
    void editCategory(Integer categoryId,String categoryName,Integer userId);
    //删除类别
    void deleteCategory(Integer categoryId);
}
