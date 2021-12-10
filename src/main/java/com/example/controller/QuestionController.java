package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.QAndAForm;

@Controller
@RequestMapping("/user")
public class QuestionController {

    @PostMapping("/question")
    public String postQuestion(@ModelAttribute QAndAForm form) {
        return "user/question";
    }
}