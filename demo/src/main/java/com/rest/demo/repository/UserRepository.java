package com.rest.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;

import com.rest.demo.domain.User;

//@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

//	@RestResource(path = "by-name")
//	List<User> findAllByName(@Param("name") String n);
}
