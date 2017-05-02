package com.niit.ChatBoxRestService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.User;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/allusers")
	public ResponseEntity<List<User>> getalluser(){
		List<User> user=userDao.getAllUser();
		
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	
	}
	
	public User addUser(){
		return null;
		
		
		
		
	}

}
