package com.stefanini.project.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable t) {
        super(t);
    }

    public BusinessException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
