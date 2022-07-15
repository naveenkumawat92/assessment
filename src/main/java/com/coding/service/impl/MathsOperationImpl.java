package com.coding.service.impl;

import com.coding.service.MathsOperation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MathsOperationImpl implements MathsOperation {

    @Override
    public Long addNumber(String[] numbers) {
        List<String> numbersList = Arrays.asList(numbers);
        return numbersList.stream().map(Long::valueOf).reduce(0L, Long::sum);
    }
}
