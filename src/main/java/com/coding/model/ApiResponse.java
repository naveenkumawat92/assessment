package com.coding.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import static com.coding.constants.GlobalConstants.SUCCESS_MESSAGE;

public class ApiResponse<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8693475442624236030L;

    @Getter
    @Setter
    T data;

    @Getter @Setter
    Integer statusCode;

    @Getter @Setter
    String message;


    public ApiResponse() {
    }

    public ApiResponse(T body) {
        this.data = body;
        this.statusCode = 0;
        this.message = SUCCESS_MESSAGE;
    }

    public ApiResponse(T body, Integer statusCode) {
        this.data = body;
        this.statusCode = statusCode;
        this.message = SUCCESS_MESSAGE;
    }

    public ApiResponse(T body, ApiStatus status) {
        this.data = body;
        this.statusCode = status.getCode();
        this.message = status.getMessage();
    }
}
