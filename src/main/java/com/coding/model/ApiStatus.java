package com.coding.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class ApiStatus implements Serializable {

    @Getter @Setter
    private Integer code;

    @Getter @Setter
    private String  message;

    @Getter @Setter
    private List<String> errors;

    public ApiStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.errors = null;
    }

    public ApiStatus(Integer code, String message, List<String> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }
}
