package com.coding.controller;

import com.coding.constants.GlobalConstants;
import com.coding.model.ApiResponse;
import com.coding.model.dto.AnswerDTO;
import com.coding.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ServiceController {


    @Autowired
    private QAService service;

    @GetMapping(value = "/get/question")
    public ResponseEntity<?> getQuestion() {
        return new ResponseEntity<>(new ApiResponse<>(service.generateQuestion()), HttpStatus.OK);
    }

    @PostMapping("/verify/answer")
    public ResponseEntity<?> submitResult(@Valid @RequestBody AnswerDTO answerDTO) {
        if (Boolean.TRUE.equals(service.validateAnswer(answerDTO))) {
            return new ResponseEntity<>(new ApiResponse<>(GlobalConstants.CORRECT_MESSAGE, HttpStatus.OK.value()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse<>(GlobalConstants.INCORRECT_MESSAGE,HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }


}
