package com.stefanini.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.project.model.Negocio;
import com.stefanini.project.model.User;
import com.stefanini.project.service.UserService;
import com.stefanini.project.validator.NegocioValidator;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NegocioValidator negocioValidator;
	
	@InitBinder("negocio")
	public void initMerchantOnlyBinder(WebDataBinder binder) {
		binder.addValidators(negocioValidator);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id) {
		return userService.findById(id).orElse(null);
	}
	
	@GetMapping
	public Iterable<User> findAll() {
		return userService.findAll();
	}

	@PostMapping
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping
	public User update(@RequestBody User user) {
		return userService.update(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}

	@PostMapping("/erro-validacao")
	public String erroValidacao(@RequestBody @Valid Negocio negocio) {
		return userService.userValidation(negocio);
	}
}
