package com.example.workout.exception;

public class ErrorResponse {
    private Integer code;

    private String message;

    private Object trace;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer code, String message, Object trace) {
        this.code = code;
        this.message = message;
        this.trace = trace;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getTrace() {
        return trace;
    }

    public void setTrace(Object trace) {
        this.trace = trace;
    }
}
