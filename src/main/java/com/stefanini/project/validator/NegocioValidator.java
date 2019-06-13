package com.stefanini.project.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.stefanini.project.model.Negocio;

@Component
public class NegocioValidator implements Validator {

    
	private static final String mensagemDeErroNomeNulo = "Nome não pode ser vazio";
	private static final String mensagemDeErroNumeroDeConta = "Numero da conta não pode ser nula ou 0";
	private static final String verificarNome = "nome";

	@Override
    public boolean supports(Class<?> clazz) {
        return Negocio.class.equals(clazz);
    }

    @Override
    public void validate(Object alvoDaValidacao, Errors errors) {
        Negocio negocio = (Negocio) alvoDaValidacao;
        ValidationUtils.rejectIfEmpty(errors, verificarNome, String.valueOf(HttpStatus.BAD_REQUEST.value()), mensagemDeErroNomeNulo);
        if (negocio.getNumeroDaConta() == null || negocio.getNumeroDaConta() == 0) {
            errors.reject(String.valueOf(HttpStatus.BAD_REQUEST.value()),mensagemDeErroNumeroDeConta);
        }
    }
}
