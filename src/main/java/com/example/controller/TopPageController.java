package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.QAndAForm;

@Controller
@RequestMapping("/user")
public class TopPageController {

    @GetMapping("/toppage")
    public String getTopPage() {
        return "user/toppage";
    }

    @PostMapping("/toppage")
    public String postTopPage(@ModelAttribute QAndAForm form) {
        return "redirect:/user/question";
    }
}