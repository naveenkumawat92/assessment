package com.coding.service;

import com.coding.model.dto.AnswerDTO;
import com.coding.model.response.GenericResponse;
import com.coding.utils.ServiceUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class QAServiceTest {

    @Mock
    private QAService service;


    @Test
    void validateAnswer_without_question() {
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAnswer("23");
        Mockito.when(service.validateAnswer(answerDTO)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class,()->service.validateAnswer(answerDTO));
    }

    @Test
    void generateQuestion() {
        String[] randomNumber = ServiceUtils.getDefaultRandomNumbers(1,100000);
        String message = "Please sum the numbers " + Arrays.toString(randomNumber).replace("[", "").replace("]", "");
        Mockito.when(service.generateQuestion()).thenReturn(GenericResponse.builder().data(message).build());
        assertNotNull(service.generateQuestion());
    }


}