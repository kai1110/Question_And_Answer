package com.example.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class AnswerForm {

    private Integer questionId;
    private String title;
    private String question;
    private String questionUserId;
    private String questionTime;
    
    @Length(max = 255)
    private String answer;

    private String answerUserId;
    
    private String answerTime;

    private boolean resolved;
}
