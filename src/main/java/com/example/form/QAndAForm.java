package com.example.form;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QAndAForm {

    private Integer questionId;
    private String title;
    private String question;
    private String questionUseId;
    private Timestamp questionTime;
    private String answer;
    private String answerUseId;
    private Timestamp answerTime;
    private boolean resolved;
}
