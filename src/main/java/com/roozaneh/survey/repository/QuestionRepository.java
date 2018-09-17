package com.roozaneh.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.roozaneh.survey.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
