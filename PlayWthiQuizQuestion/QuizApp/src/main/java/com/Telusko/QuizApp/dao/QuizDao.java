package com.Telusko.QuizApp.dao;

import com.Telusko.QuizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
