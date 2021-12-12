package com.example.repository;

import java.sql.Timestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.QAUser;

public interface QARepository extends JpaRepository<QAUser, Integer> {

    QAUser findByquestionId(Integer questionId);

	@Transactional
	@Modifying
	@Query("UPDATE QAUser SET answer=:answer, answerUserId=:answerUserId, answerTime=:answerTime  WHERE questionId=:questionId ")
	public Integer saveByIdAndAnswerTime(@Param("answer") String answer, @Param("answerUserId") String answerUserId,
			@Param("questionId") Integer questionId, @Param("answerTime")Timestamp answerTime);
}