package com.stefanini.project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.stefanini.project.validator.annotation.NumeroTelefonico;

public class NumeroTelefonicoValidator implements
ConstraintValidator<NumeroTelefonico, String> {

  @Override
  public void initialize(NumeroTelefonico numeroTelefonico) {
  }

  @Override
  public boolean isValid(String campoTelefonico,
    ConstraintValidatorContext contexto) {
      return campoTelefonico != null && campoTelefonico.matches("[0-9]+")
        && (campoTelefonico.length() > 8) && (campoTelefonico.length() < 14);
  }

}