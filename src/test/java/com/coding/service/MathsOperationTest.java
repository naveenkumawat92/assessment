package com.coding.service;

import com.coding.utils.ServiceUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MathsOperationTest {

    @Mock
    private MathsOperation mathsOperation;

    @Test
    void addNumber() {
        String[] randomNumber = ServiceUtils.getDefaultRandomNumbers(1, 100000);
        Mockito.when(mathsOperation.addNumber(Mockito.any())).thenReturn(20L);
        assertEquals(20, mathsOperation.addNumber(randomNumber));
    }


}