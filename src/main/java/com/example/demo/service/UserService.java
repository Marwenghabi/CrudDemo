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
		public User update(User u) {
			User existingUser= userRespository.findById(u.getId()).orElse(null);

			existingUser.setName(u.getName());
			existingUser.setAge(u.getAge());
			existingUser.setEmail(u.getEmail());
			existingUser.setUsername(u.getUsername());
			existingUser.setPassword(u.getPassword());
			return userRespository.save(u);  

		}

		// delete user

		public String deleteUser (int id ) {
			userRespository.deleteById(id);
			return " entity deleted " + id ;
		}

	}
