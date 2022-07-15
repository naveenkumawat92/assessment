package com.coding.constants;

public class GlobalConstants {

    private GlobalConstants() {

    }

    public static final String SUCCESS_MESSAGE = "Success";
    public static final String CORRECT_MESSAGE = "That's great ";
    public static final String INCORRECT_MESSAGE = "That's wrong please try again";

    /**
     * this class will contain all the error messages
     */
    public static class ErrorMessage {
        private ErrorMessage (){
            throw new IllegalArgumentException("Constant error message class");
        }
        public static final String INVALID_ANSWER = "Invalid request,please get new question";
    }
}
