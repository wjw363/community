package com.wjw.community.controller;

import com.wjw.community.dto.CommentDTO;
import com.wjw.community.dto.QuestionDTO;
import com.wjw.community.enums.CommentTypeEnum;
import com.wjw.community.service.CommentService;
import com.wjw.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions=questionService.selectRelated(questionDTO);
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", commentDTOS);
        model.addAttribute("relatedQuestions",relatedQuestions);
        return "question";
    }
}