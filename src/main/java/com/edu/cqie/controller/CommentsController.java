package com.edu.cqie.controller;


import com.edu.cqie.entity.Comments;
import com.edu.cqie.entity.Result;
import com.edu.cqie.service.impl.CommentsServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-05-30
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsServiceImpl commentsServiceImpl;


    /**
     * 添加评论
     * @param comments
     * @return
     */
    @PostMapping
    public Result addComments(Comments comments){
        commentsServiceImpl.addComments(comments);
        return Result.success("评论成功");
    }

    /**
     * 评论列表
     * @param articleId
     * @return
     */
    @GetMapping
    public Result commentsList(@RequestParam(name = "articleId")Integer articleId){
        List<Comments> commentsList = commentsServiceImpl.findByArticleId(articleId);
        return Result.success(commentsList);
    }

    @DeleteMapping
    public Result deleteComments(@RequestParam(name="commentId")Integer commentId){
        commentsServiceImpl.deleteComments(commentId);
        return Result.success("删除成功");
    }

}
