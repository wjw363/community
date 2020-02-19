package com.wjw.community.mapper;

import com.wjw.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}