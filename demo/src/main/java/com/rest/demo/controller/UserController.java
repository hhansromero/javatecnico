package com.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.domain.User;
import com.rest.demo.repository.UserRepository;

@RestController
public class UserController {

//	@Autowired
//	UserRepository userRepository;
//	
//	@RequestMapping(path = "/users")
//	List<User> users(){
//		return userRepository.findAll();
//	}
}
