package com.coding.service;

import com.coding.model.dto.AnswerDTO;
import com.coding.model.response.GenericResponse;

/**
 * QAService - is a interface that contains all the methods related to question and answer
 */
public interface QAService {

    Boolean validateAnswer(AnswerDTO answerDTO);

    GenericResponse generateQuestion();
}
