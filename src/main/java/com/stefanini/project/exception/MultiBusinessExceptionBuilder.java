package com.stefanini.project.exception;

import java.util.List;

public class MultiBusinessExceptionBuilder {

    private MultiBusinessException multiBusinessException;

    private MultiBusinessExceptionBuilder() {
        multiBusinessException = new MultiBusinessException();
    }

    public static MultiBusinessExceptionBuilder getInstance() {
        return new MultiBusinessExceptionBuilder();
    }

    public MultiBusinessExceptionBuilder add(BusinessException e) {
        multiBusinessException.add(e);
        return this;
    }

    public MultiBusinessExceptionBuilder add(String msg) {
        this.add(new BusinessException(msg));
        return this;
    }


    public MultiBusinessExceptionBuilder add(List<String> list) {
        list.forEach(this::add);
        return this;
    }

    public void addAndThrow(String msg) {
        add(msg);
        handleThrowException();
    }

    public void addIf(String msg, boolean condition) {
        if (condition) add(msg);
    }

    public void handleThrowException() {
        if (multiBusinessException != null) {
            throw multiBusinessException;
        }
    }

}
