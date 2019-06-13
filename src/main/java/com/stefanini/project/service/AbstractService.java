package com.stefanini.project.service;

import com.stefanini.project.exception.MultiBusinessExceptionBuilder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.DataBinder;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractService {
    MultiBusinessExceptionBuilder builder;

    public AbstractService() {
        builder = MultiBusinessExceptionBuilder.getInstance();
    }

    protected List<String> getErrors(DataBinder binder) {
        return binder.getBindingResult().getAllErrors()
                     .stream()
                     .map(DefaultMessageSourceResolvable::getDefaultMessage)
                     .collect(Collectors.toList());
    }
}
