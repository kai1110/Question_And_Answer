package com.example.domain.user.service;

import com.example.domain.user.model.QAUser;

public interface QAService {

    public void question(QAUser qauser);


    /** 回答登録 */
    public Integer saveAnswer(QAUser qa);

    /** 質問・回答取得 */
    public QAUser getQAById(Integer questionId);

    /** 質問削除 */
    public void deleteById(Integer questionId);
}