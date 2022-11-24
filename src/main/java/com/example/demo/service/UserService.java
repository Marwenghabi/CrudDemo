package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRespository;


	@Service
	public class UserService {

		@Autowired
		private UserRespository userRespository ;


		//add user
		public User addUser(User user) {
			return  userRespository.save(user);  

		}
		
		//find user with id
		public User getUserById(int id) {
			return  userRespository.findById(id).get();  
		}



		//update 
		public User update(User emp) {
			User existingUser= userRespository.findById(emp.getId()).orElse(null);

			existingUser.setName(emp.getName());
			existingUser.setAge(emp.getAge());
			existingUser.setEmail(emp.getEmail());
			existingUser.setUsername(emp.getUsername());
			return userRespository.save(emp);  

		}

		// delete user

		public String deleteUser (int id ) {
			userRespository.deleteById(id);
			return " entity deleted " + id ;
		}

	}
