package com.stefanini.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.project.model.Authority;
import com.stefanini.project.repository.AuthorityRepository;

@Service
public class AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepositry;
	
	public Iterable<Authority> findAll() {
		return authorityRepositry.findAll();
	}
}
