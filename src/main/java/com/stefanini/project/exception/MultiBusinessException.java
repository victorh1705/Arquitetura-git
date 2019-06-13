package com.stefanini.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MultiBusinessException extends RuntimeException {
    private final List<BusinessException> exceptions = new ArrayList<>();

    public MultiBusinessException() {
    }

    public void add(BusinessException e) {
        exceptions.add(e);
    }

    public void add(String msg) {
        add(msg);
    }

    public List<BusinessException> getExceptions() {
        return exceptions;
    }

    public List<String> getExceptionsList() {
        return exceptions.stream()
                         .map(BusinessException::toString)
                         .collect(Collectors.toList());
    }
}
