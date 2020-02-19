package com.wjw.community.mapper;

import com.wjw.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);
}