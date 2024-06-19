package com.edu.cqie.service;

import com.edu.cqie.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.cqie.entity.PageBean;

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
    //条件分页列表查询
    PageBean<Article> articleList(Integer pageNum, Integer pageSize, Integer categoryId, String status);
    //修该文章状态
    void checkArticle(String status,Integer articleId);
    //管理员查询文章
    PageBean<Article> findAllArticle(Integer pageNum, Integer pageSize);
    //跟据文章状态查询
    PageBean<Article> findArticleByStatus(Integer pageNum, Integer pageSize, String status);
}
