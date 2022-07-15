package com.coding.service.impl;

import com.coding.constants.GlobalConstants;
import com.coding.model.dto.AnswerDTO;
import com.coding.model.response.GenericResponse;
import com.coding.service.MathsOperation;
import com.coding.service.QAService;
import com.coding.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
public class QAServiceImpl implements QAService {

    @Autowired
    private MathsOperation mathsOperation;

    protected static String[] generatedNumbers;

    @Override
    public Boolean validateAnswer(AnswerDTO answerDTO) {
        if (Objects.isNull(generatedNumbers)) {
            throw new IllegalArgumentException(GlobalConstants.ErrorMessage.INVALID_ANSWER);
        }
        Long result = mathsOperation.addNumber(generatedNumbers);
        return Objects.equals(result,Long.valueOf(answerDTO.getAnswer()));
    }

    @Override
    public GenericResponse generateQuestion() {
        String[] defaultRandomNumbers = ServiceUtils.getDefaultRandomNumbers(1, 100000);
        generatedNumbers = defaultRandomNumbers;
        String message = "Please sum the numbers " + Arrays.toString(defaultRandomNumbers).replace("[", "").replace("]", "");
        return GenericResponse.builder().data(message).build();

    }
}
