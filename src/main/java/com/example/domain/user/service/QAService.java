package com.example.domain.user.service;

import com.example.domain.user.model.QAUser;

public interface QAService {

    public void question(QAUser qauser);


    /** �񓚓o�^ */
    public Integer saveAnswer(QAUser qa);

    /** ����E�񓚎擾 */
    public QAUser getQAById(Integer questionId);

    /** ����폜 */
    public void deleteById(Integer questionId);
}