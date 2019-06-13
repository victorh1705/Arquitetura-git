package com.stefanini.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.project.model.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

}
