package com.stefanini.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.project.security.AuthenticationDTO;

@RestController
public class LoginController {


	@PostMapping("/login")
	public String login(@RequestBody AuthenticationDTO authentication) {
		// TODO Método criado apenas para aparecer no Swagger. Ver outra forma para exibir.
		return "redirect:/login";
	}
}
