package com.Telusko.QuizApp.controller;


import com.Telusko.QuizApp.Model.Question;
import com.Telusko.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionConroller {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }

    @DeleteMapping("Delete/{questionId}")
    public ResponseEntity<String> deleteQuestion(Integer questionId){
        return questionService.deleteQuestion(questionId);
    }
}
