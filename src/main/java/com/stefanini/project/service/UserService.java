package com.stefanini.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.stefanini.project.model.Negocio;
import com.stefanini.project.model.User;
import com.stefanini.project.repository.UserRepository;

@Service
public class UserService extends AbstractService {

	@Autowired
	private UserRepository userRepository;

    public UserService() {
        super();
    }

    public User save(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		return this.save(user);
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Secured("ADMIN")
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

    public String userValidation(Negocio negocio) {
        return "NEGOCIO CONCLUIDO";
    }

}
