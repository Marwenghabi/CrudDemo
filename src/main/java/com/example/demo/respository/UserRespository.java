package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;



public interface UserRespository  extends JpaRepository <User, Integer >{

}
