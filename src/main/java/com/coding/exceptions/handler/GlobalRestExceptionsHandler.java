package com.coding.exceptions.handler;


import com.coding.model.ApiResponse;
import com.coding.model.ApiStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class GlobalRestExceptionsHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value
            = {NullPointerException.class})
    protected ResponseEntity<?> handleNullPointerExceptions(
            Exception e, WebRequest request) {

        return ResponseEntity.status(500)
                .body(new ApiResponse<>(null, new ApiStatus(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal exception occurred")));
    }

    @ExceptionHandler({IllegalArgumentException.class, NumberFormatException.class})
    public ResponseEntity<?> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(new ApiResponse<>(null, new ApiStatus(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage())));
    }
}