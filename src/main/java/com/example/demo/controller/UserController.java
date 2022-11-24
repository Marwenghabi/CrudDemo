package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRespository;
import com.example.demo.service.UserService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRespository userRespository;
	private UserService userService;
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	@GetMapping("all")
	public List<User> getUsers(){
		return this.userRespository.findAll();
		
	}
	@GetMapping(path="{id}")
	public User finduser(@PathVariable int id) {
		//return userService.getUserById(id);
		return  userRespository.findById(id).get();  
	}
}
