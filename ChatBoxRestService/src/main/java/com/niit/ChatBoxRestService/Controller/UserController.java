package com.niit.ChatBoxRestService.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.User;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;

	@Autowired
	User user;

	@Autowired
	HttpSession session;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User newuser) {

		userDao.add(newuser);
		newuser.setErrorCode("200");
		newuser.setErrorMessage("Thanks for registration " +newuser.getName());
		//session.setAttribute("userId", user.getUserId());

		return new ResponseEntity<User>(newuser, HttpStatus.OK);
	}

//	//@SuppressWarnings("null")
//	@GetMapping("/login/{}")
//	public ResponseEntity<User> validateUser(@RequestBody User user,@PathVariable("email") String email, @PathVariable("password") String password) {
//       user=userDao.validate(email,password);
//       
//		if(userDao.validate(email, password)!=null){
//			user=userDao.getByEmail(email);
//			user.setErrorCode("200");
//			user.setErrorMessage("User  found with email");
//			return new ResponseEntity<User>(user,HttpStatus.OK);
//		}else{
//			User nwuser=new User();
//			nwuser.setErrorCode("404 ");
//			nwuser.setErrorMessage("User not found with email");
//			return new ResponseEntity<User>(nwuser,HttpStatus.NOT_FOUND);
//		}
//		
//	}
//		user = userDao.getByEmail(email);
//		if (user != null) {
//			if (password.equals(user.getPassword())) {
//				user.setErrorCode("200");
//				user.setErrorMessage("You have logged in successfully");
//			}
//
//		} else {
//			user = new User();
//			user.setErrorCode("404");
//			user.setErrorMessage("Invalid Credentials..");
//		}
//		return user;
//	}
//*/
	@PutMapping("/updateuser")
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
		if (user != null && ((u.getPassword()).equals(user.getPassword()))) {
			
				user.setErrorCode("200");
				user.setErrorMessage("You have logged in successfully " +user.getName());
				return new ResponseEntity<User>(user,HttpStatus.OK);
			
		} else {
			
			u.setErrorCode("404");
			u.setErrorMessage("Invalid Credentials..");
			return new ResponseEntity<User>(u,HttpStatus.NOT_FOUND);
		}
		
	}


}
