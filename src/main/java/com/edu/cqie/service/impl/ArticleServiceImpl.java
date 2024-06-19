package com.edu.cqie.service.impl;

import com.edu.cqie.entity.Article;
import com.edu.cqie.entity.PageBean;
import com.edu.cqie.mapper.ArticleMapper;
import com.edu.cqie.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.cqie.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加新文章
     * @param article
     */
    public void addArticle(Article article){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setAuthorId(userId);
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

    /**
     * 修改文章
     * @param articleId
     * @param article
     */
    public void editArticle(Integer articleId,Article article){
        articleMapper.editArticle(articleId,article);
    }

    /**
     * 删除文章
     * @param articleId
     */
    public void deleteArticle(Integer articleId){
        articleMapper.deleteArticle(articleId);
    }

    /**
     * 条件分页列表查询
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @param status
     * @return
     */
    @Override
    public PageBean<Article> articleList(Integer pageNum, Integer pageSize, Integer categoryId, String status) {
        //创建PageBean对象
        PageBean<Article> pb = new PageBean<>();
        //开启分页查询  PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as=articleMapper.articleList(userId,categoryId,status);
        //Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<Article> p=(Page<Article>) as;
        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    /**
     * 修改文章状态
     * @param status
     */
    @Override
    public void checkArticle(String status,Integer articleId) {
        articleMapper.checkArticle(status,articleId);
    }

    /**
     * 管理员查询文章列表
     * @param pageNum
     * @param pageSize
     * @param
     * @return
     */
    @Override
    public PageBean<Article> findAllArticle(Integer pageNum, Integer pageSize) {
        //创建PageBean对象
        PageBean<Article> pb = new PageBean<>();
        //开启分页查询  PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //调用mapper
        List<Article> as=articleMapper.findAllArticle();
        System.out.println("======================");
        System.out.println(as);
        System.out.println("======================");
        //Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<Article> p=(Page<Article>) as;
        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    /**
     * 跟据文章状态查询
     * @param pageNum
     * @param pageSize
     * @param status
     * @return
     */
    @Override
    public PageBean<Article> findArticleByStatus(Integer pageNum, Integer pageSize, String status) {
        //创建PageBean对象
        PageBean<Article> pb = new PageBean<>();
        //开启分页查询  PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //调用mapper
        List<Article> as=articleMapper.findArticleByStatus(status);
        //Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<Article> p=(Page<Article>) as;
        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
