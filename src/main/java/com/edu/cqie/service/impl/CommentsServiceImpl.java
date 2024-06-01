package com.edu.cqie.service.impl;

import com.edu.cqie.entity.Comments;
import com.edu.cqie.mapper.CommentsMapper;
import com.edu.cqie.service.ICommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    /**
     * 对文章进行评论
     * @param comments
     */
    @Override
    public void addComments(Comments comments) {
        commentsMapper.addComments(comments);
    }

    /**
     * 获取某篇文章的所有评论
     * @param articleId
     * @return
     */
    @Override
    public List<Comments> findByArticleId(Integer articleId) {
        return commentsMapper.findByArticleId(articleId);
    }

    @Override
    public void deleteComments(Integer commentId) {
        commentsMapper.deleteComments(commentId);
    }


}
