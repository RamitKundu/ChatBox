package com.niit.ChatBoxRestService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ChatBoxBackEnd.Dao.UserProfileDao;
import com.niit.ChatBoxBackEnd.Model.UserProfile;

@RestController
public class UserProfileController {
	
	@Autowired
	UserProfileDao userProfileDao;
	
	
	@PostMapping("/adduserprofile")
	public ResponseEntity<UserProfile> addProfile(@RequestBody UserProfile userProfile){
		
		userProfileDao.addUserProfile(userProfile);
		return new ResponseEntity<UserProfile>(userProfile,HttpStatus.OK);
	}
     
	@GetMapping("/getalluserprofile")
	public ResponseEntity <List<UserProfile>> getAll(){
		List<UserProfile> getalluserProfile=userProfileDao.getallUProfile();
		return new ResponseEntity<List<UserProfile>>(getalluserProfile,HttpStatus.OK);
		
	}
}
