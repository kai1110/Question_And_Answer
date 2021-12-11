package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.user.model.QAUser;

public interface QARepository extends JpaRepository<QAUser, Integer> {

    QAUser findByquestionId(Integer questionId);
}