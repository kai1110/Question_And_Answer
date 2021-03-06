package com.example.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.QAUser;
import com.example.domain.user.service.QAService;
import com.example.repository.QARepository;

@Service
@Primary
public class QAServiceImpl implements QAService {

    @Autowired
    private QARepository repository;

    @Transactional
    @Override
    public void question(QAUser qauser) {

        repository.save(qauser);
    }

	/** ño^ */
    @Transactional
    @Override
    public Integer saveAnswer(QAUser qa) {
        // o^
        return repository.saveByIdAndAnswerTime(qa.getAnswer(), qa.getAnswerUserId(),
                qa.getQuestionId(), qa.getAnswerTime());
    }

    /** ¿âñæ¾ */
    @Override
    public QAUser getQAById(Integer questionId) {
            // QAæ¾
            return repository.getById(questionId);
    }
    /** ¿âí */
    public void deleteById(Integer questionId) {
           repository.deleteById(questionId);
    }
}