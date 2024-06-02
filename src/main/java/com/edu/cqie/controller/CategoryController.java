package com.edu.cqie.controller;


import com.edu.cqie.entity.Article;
import com.edu.cqie.entity.Category;
import com.edu.cqie.entity.Result;
import com.edu.cqie.service.impl.CategoryServiceImpl;
import com.edu.cqie.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    /**
     * 获取所有文章分类
     * @return
     */
    @GetMapping("/list")
    public Result showAll(/*@RequestHeader(name="Authorization")String token, HttpServletResponse response*/){
//        try {
//            //验证token
//            Map<String,Object> claims= JwtUtil.parseToken(token);
//            List<Category> list = categoryServiceImpl.list();
//            System.out.println(list);
//            return Result.success(list);
//        } catch (Exception e) {
//            //设置http响应状态码
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        List<Category> list = categoryServiceImpl.list();
        System.out.println(list);
        return Result.success(list);
    }

    /**
     * 新增文章类别
     * @param userId
     * @param categoryName
     * @return
     */
    @PostMapping("/add")
    public Result addCategory(Integer userId, String categoryName){
        categoryServiceImpl.addCategory(userId,categoryName);
        return Result.success("新增成功");
    }

    /**
     * 编辑类别
     * @param categoryId
     * @param categoryName
     * @return
     */
    @PutMapping
    public Result editCategory(@RequestParam(name = "category_id")Integer categoryId,String categoryName){
        //userId可以通过session获取，现在先写死
        categoryServiceImpl.editCategory(categoryId,categoryName,2);
        return Result.success("修改成功");
    }


    @DeleteMapping
    public Result deleteCategory(@RequestParam(name = "categoryId")Integer categoryId){
        categoryServiceImpl.deleteCategory(categoryId);
        return Result.success("删除类别成功");
    }
}
