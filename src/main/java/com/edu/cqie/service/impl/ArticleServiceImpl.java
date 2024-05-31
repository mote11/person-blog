package com.edu.cqie.service.impl;

import com.edu.cqie.entity.Article;
import com.edu.cqie.mapper.ArticleMapper;
import com.edu.cqie.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加新文章
     * @param article
     */
    public void addArticle(Article article){
        articleMapper.addArticle(article);
    }

    /**
     * 跟据文章分类查询文章
     * @param categoryId
     * @return
     */
    public List<Article> findArticle(Integer categoryId){
        return articleMapper.findArticle(categoryId);
    }

    /**
     * 跟据文章id查询该篇文章
     * @param articleId
     * @return
     */
    public Article findArticleById(Integer articleId){
        return articleMapper.findArticleById(articleId);
    }
}
