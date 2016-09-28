package com.qk.practice.model;

import org.springframework.http.HttpStatus;

public class Response {
    private HttpStatus httpStatus;
    private String message;
    private Object data;

    public Response() {
        super();
    }

    public Response(HttpStatus httpStatus, String message, Object data) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
