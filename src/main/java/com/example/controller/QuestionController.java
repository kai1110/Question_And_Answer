package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.QAUser;
import com.example.domain.user.service.QAService;
import com.example.form.QAndAForm;

@Controller
@RequestMapping("/user")
public class QuestionController {

    @Autowired
    private QAService qaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/toppage")
    public String postQuestion(@ModelAttribute QAndAForm form) {

        QAUser qa = modelMapper.map(form, QAUser.class);

        qaService.saveQuestion(qa);

        return "redirect:user/toppage";
    }

    @PostMapping("/question/destroy/{questionId}")
    public String destroyQuestion(@PathVariable Integer questionId) {
        //  質問情報を取得
        qaService.deleteById(questionId);
        return "redirect:/user/toppage";
    }
}