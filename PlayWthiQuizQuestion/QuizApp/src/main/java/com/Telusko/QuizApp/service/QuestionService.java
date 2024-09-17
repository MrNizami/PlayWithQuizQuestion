package com.Telusko.QuizApp.service;

import com.Telusko.QuizApp.Model.Question;
import com.Telusko.QuizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestion(){
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("not added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer questionId) {
        try{
            questionDao.deleteById(questionId);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("not deleted",HttpStatus.BAD_REQUEST);
    }
}
