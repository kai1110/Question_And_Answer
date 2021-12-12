package com.example.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.QAUser;
import com.example.domain.user.model.impl.UserDetailsImpl;
import com.example.domain.user.service.QAService;
import com.example.form.AnswerForm;


@Controller
@RequestMapping("/user")
public class AnswerController {

    @Autowired
    private QAService qaService;

    @GetMapping("/answer/{questionId}")
    public String newAnswer(@PathVariable Integer questionId, Model model,
           @AuthenticationPrincipal UserDetailsImpl userDetails) {
           //  質問情報を取得
          QAUser qa = qaService.getQAById(questionId);
          AnswerForm form = this.toForm(qa);

          model.addAttribute("form", form);
          boolean isEdit = false;
          String answerUserId =qa.getAnswerUserId();
          String loginUserId = userDetails.getUserId();
         if (answerUserId == null || answerUserId.equals(loginUserId)) {
              isEdit = true;
         }
         model.addAttribute("isEdit", isEdit);
        return "user/answer";
    }
    @PostMapping("/answer")
    public String saveAnswer(@ModelAttribute("form") AnswerForm form,
            @AuthenticationPrincipal UserDetailsImpl userDetails, final BindingResult bindingResult) {
         // 入力チェック
        if (bindingResult.hasErrors()) {
            // 入力チェックエラー時の処理
            return "user/answer";
        }
        
        QAUser qa = this.toEntity(form, userDetails);
        
        // 回答を登録
        qaService.saveAnswer(qa);
        return "redirect:/user/toppage";
    }
    @PostMapping("/answer/destroy/{questionId}")
    public String destroyAnswer(@PathVariable Integer questionId) {
        //  質問情報を取得
        QAUser qa = qaService.getQAById(questionId);
        
        qa.setAnswerUserId(null);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        qa.setAnswerTime(currentTime);
        qa.setAnswer("");
        
        // 回答を削除
        qaService.saveAnswer(qa);
        return "redirect:/user/toppage";
    }
	private AnswerForm toForm(QAUser qa) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		
		AnswerForm form = new AnswerForm();
		form.setQuestionId(qa.getQuestionId());
		form.setTitle(qa.getTitle());
		form.setQuestion(qa.getQuestion());
		form.setQuestionUserId(qa.getQuestionUserId());
		form.setQuestionTime(dateFormat.format(qa.getQuestionTime()));
		form.setAnswer(qa.getAnswer());
		form.setAnswerUserId(qa.getAnswerUserId());
		if (qa.getAnswerTime() != null) {
			form.setAnswerTime(dateFormat.format(qa.getAnswerTime()));
		}
		form.setResolved(qa.isResolved());

		return form;
	}
	private QAUser toEntity(AnswerForm form, UserDetailsImpl userDetails) {

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		QAUser qa = new QAUser();
		qa.setQuestionId(form.getQuestionId());
		qa.setTitle(form.getTitle());
		qa.setQuestion(form.getQuestion());
		qa.setQuestionUserId(form.getQuestionUserId());
		
		qa.setQuestionTime(Timestamp.valueOf(form.getQuestionTime()));
		qa.setAnswer(form.getAnswer());
		qa.setAnswerUserId(userDetails.getUserId());
		qa.setAnswerTime(currentTime);
		qa.setResolved(form.isResolved());

		return qa;
	}
}