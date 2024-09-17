package com.Telusko.QuizApp.controller;



import com.Telusko.QuizApp.Model.QuestionWrapper;
import com.Telusko.QuizApp.Model.Response;
import com.Telusko.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
         return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
      return  quizService.getQuizQuestion(id);
    }

    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id, @RequestBody List<Response>responses){
        return quizService.calculateresult(id,responses);
    }
}


