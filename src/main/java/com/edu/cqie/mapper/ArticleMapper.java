package com.edu.cqie.mapper;

import com.edu.cqie.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 添加文章
     * @param article
     */
    @Insert("insert into article(title,content,category_id,author_id,status,create_time,update_time) values " +
            "(#{title},#{content},#{categoryId},#{authorId},'audit'," +
            "now(),now())")
    void addArticle(Article article);

    /**
     * 跟据文章分类查询文章
     * @param categoryId
     * @return
     */
    @Select("select * from article where category_id=#{categoryId}")
    List<Article> findArticle(Integer categoryId);

    /**
     * 跟据文章id查询该篇文章
     * @param articleId
     * @return
     */
    @Select("select * from article where article_id=#{articleId}")
    Article findArticleById(Integer articleId);
}
