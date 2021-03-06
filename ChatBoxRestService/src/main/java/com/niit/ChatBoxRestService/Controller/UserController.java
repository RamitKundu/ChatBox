package com.niit.ChatBoxRestService.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.User;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;

	@Autowired
	User user;

	@Autowired
	 private HttpSession hs;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User newuser) {

		userDao.add(newuser);
		newuser.setErrorCode("200");
		newuser.setErrorMessage("Thanks for registration " +newuser.getFullName());
		//session.setAttribute("userId", user.getUserId());

		return new ResponseEntity<User>(newuser, HttpStatus.OK);
	}

	@PostMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		// user=userDao.getById(userId);
		userDao.update(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@GetMapping("/getById/{userId}")
	public ResponseEntity<User> getById(@PathVariable("userId") int userId) {
		if (userDao.getById(userId) == null) {
			user.setErrorCode("404");
			user.setErrorMessage("No user found by Id");
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		} else {
			User newUser = new User();
			newUser = userDao.getById(userId);
			newUser.setErrorCode("200");
			newUser.setErrorMessage("Valid User found by Id");
			return new ResponseEntity<User>(newUser, HttpStatus.OK);
		}

	}

	@GetMapping("/getalluser")
	public ResponseEntity<List<User>> listofUser() {
		List<User> userlist = userDao.getAllUser();
		if (userlist.isEmpty()) {
			user.setErrorCode("100");
			user.setErrorMessage("Users not found in the list");
			return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);
		}
		user.setErrorCode("200");
		user.setErrorMessage("Users found in the list");
		return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId) {
		User user = userDao.getById(userId);
		userDao.delete(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	 //--------------------authenticate-------------------------
	
	@PostMapping("/login")
	public ResponseEntity<User> validateUser(@RequestBody User u) {
   		user = userDao.getByEmail(u.getEmail());
   		
   		hs.setAttribute("email", user);
   		
		if (user != null && ((u.getPassword()).equals(user.getPassword()))) {
			    user.setIsOnline("OnLine");
			    userDao.setOnline(user.getUserId());
				user.setErrorCode("200");
				user.setErrorMessage("You have logged in successfully " +user.getFullName());
				return new ResponseEntity<User>(user,HttpStatus.OK);
			
		} else {
			
			u.setErrorCode("404");
			u.setErrorMessage("Invalid Credentials..");
			return new ResponseEntity<User>(u,HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Upload Images.....!!!
	
/*	 @ResponseStatus(HttpStatus.OK)
	    @RequestMapping(value = "/upload")
	    public void upload(@RequestParam("file") MultipartFile file ) throws IOException {

	        byte[] bytes;

	        if (!file.isEmpty()) {
	             bytes = file.getBytes();
	            //store file in storage
	        }

	        System.out.println(String.format("receive %s from %s", file.getOriginalFilename()));
	    }*/
	

	@PostMapping("/logout")
	public ResponseEntity<User> Logout(@RequestBody User user) {
		user.setIsOnline("OffLine");
		userDao.update(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}


}
