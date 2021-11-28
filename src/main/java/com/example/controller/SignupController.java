package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.GroupOrder;
import com.example.form.signupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

    /** ユーザー登録画面を表示 */
    @GetMapping("/signup")
    public String getSignup(signupForm form, Model model) {

        // ユーザー登録画面に遷移
        return "user/signup";
    }

    /** ユーザー登録処理 */
    @PostMapping("/signup")
    public String postSignup(Model model, @ModelAttribute @Validated(GroupOrder.class) signupForm form, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return getSignup(form, model);
        }

        log.info(form.toString());

        // ログイン画面にリダイレクト
        return "redirect:/login";
    }
}