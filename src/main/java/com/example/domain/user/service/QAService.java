package com.example.domain.user.service;

import com.example.domain.user.model.QAUser;

public interface QAService {

    public void question(QAUser qauser);


    /** ‰ñ“š“o˜^ */
    public Integer saveAnswer(QAUser qa);

    /** ¿–âE‰ñ“šæ“¾ */
    public QAUser getQAById(Integer questionId);

    /** ¿–âíœ */
    public void deleteById(Integer questionId);
}