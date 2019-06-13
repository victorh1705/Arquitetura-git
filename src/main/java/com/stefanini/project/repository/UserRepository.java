package com.stefanini.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stefanini.project.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("select u from User u left join fetch u.authorities where u.username = :username")
	User findByUsername(@Param("username") String username);

}
