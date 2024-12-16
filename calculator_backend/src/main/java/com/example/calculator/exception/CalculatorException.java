package com.example.calculator.exception;

public class CalculatorException extends Exception {
    private final ErrorCode errorCode;

    public enum ErrorCode {
        DivByZero("Error: division by zero"),
        DivByMax("Error: number too large");

        private final String message;

        private ErrorCode (String message){
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

    public CalculatorException(ErrorCode errorCode) {
        super(errorCode.message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
