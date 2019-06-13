package com.stefanini.project.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.stefanini.project.validator.NumeroTelefonicoValidator;



@Documented
@Constraint(validatedBy = NumeroTelefonicoValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NumeroTelefonico {
    String message() default "número telefonico inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}