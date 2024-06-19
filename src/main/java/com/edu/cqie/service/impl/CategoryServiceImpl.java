package com.edu.cqie.service.impl;

import com.edu.cqie.entity.Category;
import com.edu.cqie.mapper.CategoryMapper;
import com.edu.cqie.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.cqie.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增文章类别
     * @param categoryName
     */
    @Override
    public void addCategory( String categoryName) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");

        categoryMapper.addCategory(userId,categoryName);
    }


    /**
     * 编辑类别
     */
    @Override
    public void editCategory(Category category) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setUserId(userId);
        categoryMapper.editCategory(category);
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
