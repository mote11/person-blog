package com.edu.cqie.service;

import com.edu.cqie.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
public interface IArticleService extends IService<Article> {
    //发布文章
    void addArticle(Article article);
    //获取某类别的所有文章
    List<Article> findArticle(Integer categoryId);
    //查询某篇具体文章
    Article findArticleById(Integer articleId);
    //修改文章
    void editArticle(Integer articleId,Article article);
    //删除文章
    void deleteArticle(Integer articleId);
}
