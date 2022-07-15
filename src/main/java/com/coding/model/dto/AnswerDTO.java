package com.coding.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class AnswerDTO implements Serializable {

    @NotBlank(message = "Answer can not be blank")
    private String answer;

}