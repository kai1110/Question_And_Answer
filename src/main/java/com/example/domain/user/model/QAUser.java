package com.example.domain.user.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="qa_user")
public class QAUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String title;
    private String question;
    private String questionUserId;
    private Timestamp questionTime;
    private String answer;
    private String answerUserId;
    private Timestamp answerTime;
    private boolean resolved;
}