package com.edu.cqie.controller;


import com.edu.cqie.entity.Article;
import com.edu.cqie.entity.Result;
import com.edu.cqie.service.impl.ArticleServiceImpl;
import com.edu.cqie.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
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
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    /**
     * 发布文章，开始状态为audit，审核中
     *
     * @param article
     * @return
     */
    @PostMapping("/up")
    public Result upload(Article article) {
        articleServiceImpl.addArticle(article);
        return Result.success("文章发布成功，等待审核");
    }

    /**
     * 跟据文章分类查询出该类型的所有文章
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    public Result findArticle(@RequestParam(name = "categoryId") Integer categoryId) {
        //@RequestParam(name="categoryId")可加可不加，因为前端传递数据的名称也是categoryId，与函数参数名一致
        List<Article> article = articleServiceImpl.findArticle(categoryId);
        //输出获取到的数据
        for (Article article1 : article) {
            System.out.println(article1);
        }
        return Result.success(article);
    }


    /**
     * 获取文章详情
     *
     * @param articleId
     * @return
     */
    @GetMapping
    public Result articleDes(@RequestParam(name = "article_id") Integer articleId) {
        Article article = articleServiceImpl.findArticleById(articleId);
        return Result.success(article);
    }

    /**
     * 修改文章有点问题，后面再改
     *
     * @param articleId
     * @param article
     * @return
     */
    @PutMapping
    public Result editArticle(@RequestParam(name = "article_id") Integer articleId, Article article) {
        //修改文章
        System.out.println(article.toString());
        System.out.println(articleId);
        articleServiceImpl.editArticle(articleId, article);
        return Result.success("文章修改成功");
    }


    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @DeleteMapping
    public Result deleteArticle(@RequestParam(name = "article_id") Integer articleId) {
        articleServiceImpl.deleteArticle(articleId);
        return Result.success("删除文章成功");
    }

}





