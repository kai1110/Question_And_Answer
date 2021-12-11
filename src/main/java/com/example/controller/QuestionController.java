package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

        QAUser qauser = modelMapper.map(form, QAUser.class);

        qaService.question(qauser);

        return "redirect:user/toppage";
    }
}