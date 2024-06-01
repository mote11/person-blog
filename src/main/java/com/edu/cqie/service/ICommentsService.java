package com.edu.cqie.service;

import com.edu.cqie.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
public interface ICommentsService extends IService<Comments> {
    //对文章进行评论
    void addComments(Comments comments);
    //获取某篇文章的所有评论
    List<Comments> findByArticleId(Integer articleId);
    //删除评论
    void deleteComments(Integer commentId);
}
