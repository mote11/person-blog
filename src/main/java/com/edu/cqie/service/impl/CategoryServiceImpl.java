package com.edu.cqie.service.impl;

import com.edu.cqie.entity.Category;
import com.edu.cqie.mapper.CategoryMapper;
import com.edu.cqie.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增文章类别
     * @param userId
     * @param categoryName
     */
    @Override
    public void addCategory(Integer userId, String categoryName) {
        categoryMapper.addCategory(userId,categoryName);
    }


    /**
     * 编辑类别
     * @param categoryId
     * @param categoryName
     * @param userId
     */
    @Override
    public void editCategory(Integer categoryId, String categoryName,Integer userId) {
        categoryMapper.editCategory(categoryId,categoryName,userId);
    }

    /**
     * 删除类别
     * @param categoryId
     */
    @Override
    public void deleteCategory(Integer categoryId) {
        categoryMapper.deleteCategory(categoryId);
    }
}
