package com.example.domain.user.service;

import com.example.domain.user.model.QAUser;

public interface QAService {

    public Integer saveQuestion(QAUser qa);

    public Integer saveAnswer(QAUser qa);

    public QAUser getQAById(Integer questionId);

    public void deleteById(Integer questionId);
}