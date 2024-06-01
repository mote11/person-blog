package com.edu.cqie.mapper;

import com.edu.cqie.entity.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
public interface CommentsMapper extends BaseMapper<Comments> {

    /**
     * 对文章进行评论
     * @param comments
     */
    @Insert("insert into  comments(article_id,user_id,com_content,created_time) values " +
            "(#{comments.articleId},#{comments.userId},#{comments.comContent},now())")
    void addComments(@Param("comments") Comments comments);

    /**
     * 评论列表
     * @param articleId
     * @return
     */
    @Select("select * from comments where article_id=#{articleId}")
    List<Comments> findByArticleId(@Param("articleId") Integer articleId);

    @Delete("delete from comments where comment_id=#{commentId}")
    void deleteComments(@Param("commentId")Integer commentId);
}
