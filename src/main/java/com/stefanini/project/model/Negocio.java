package com.stefanini.project.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.stefanini.project.validator.annotation.NumeroTelefonico;

public class Negocio extends AbstractModel {
	
    @NotBlank(message = "{name.not.blank}")
    @Size(min = 3, max = 100, message = "{name.not.size.valid}" )
    public String nome;
    
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    public String email;

    @Min(value = 1 , message = "{numeroConta.not.valid}")
    @Max(999999)
    public Long numeroDaConta;
    
    @NumeroTelefonico
    public String telefone;

	public Negocio(
			@NotBlank(message = "{name.not.blank}") @Size(min = 3, max = 100, message = "{name.not.size.valid}") String nome,
			@NotBlank(message = "{email.not.blank}") @Email(message = "{email.not.valid}") String email,
			@Min(value = 1, message = "{numeroConta.not.valid}") @Max(999999) Long numeroDaConta, String telefone) {
		this.nome = nome;
		this.email = email;
		this.numeroDaConta = numeroDaConta;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Long numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
    
    
}
