package com.niit.ChatBoxRestService.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ChatBoxBackEnd.Dao.FriendDao;

import com.niit.ChatBoxBackEnd.Model.Friend;
import com.niit.ChatBoxBackEnd.Model.User;

@RestController
public class FriendController {
	
	@Autowired
	FriendDao fDao;
	
	Friend friend;
	
	@PostMapping("/sendrequest")
	public ResponseEntity<Void> sendFriendReq(@RequestBody Friend friend){
		if(fDao.addFreind(friend)==true){
			Friend f=new Friend();
			
			f.setUser(friend.getFriend());
			f.setFriend(friend.getUser());
			f.setStatus("New");
			f.setInitiator(0);	
			fDao.addFreind(f);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
		 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	}
	@PostMapping("/acceptfrnd")
	public ResponseEntity<Void> accpt_rjctFrndrqst(@RequestBody Friend friend){
		
		if(fDao.updateFriend(friend)==true){
			friend.setErrorCode("200");
			friend.setErrorMessage("User is updated from frontend");
//			int friendId=friend.getFriend().getUserId();
//			int userId=friend.getUser().getUserId();
		Friend friend1=fDao.getByid(friend.getFriend().getUserId(),friend.getUser().getUserId());
			friend1.setStatus(friend.getStatus());
			if(fDao.updateFriend(friend1)==true){
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
			
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}	
		
	@GetMapping("/getallmyfrnds/{userId}")
	public ResponseEntity<List<Friend>> listofFriends(@PathVariable("userId") int userId) {
		List<Friend> frndlist = fDao.getmyFriends(userId);
		Friend frnd=new Friend();
		if (frndlist!=null) {
			
			frnd.setErrorCode("200");
			frnd.setErrorMessage("All your friends found in the list");
			return new ResponseEntity<List<Friend>>(frndlist, HttpStatus.OK);
		}else{
		frnd.setErrorCode("404");
		frnd.setErrorMessage("No Friends found in the list");
		return new ResponseEntity<List<Friend>>(frndlist, HttpStatus.OK);

	}
	
	}		
		
	@GetMapping("/getallsentrqst/{userId}")
	public ResponseEntity <List<Friend>> listofFrndRqstSent(@PathVariable("userId") int userId){
		
		List<Friend> frndrqstsend=fDao.getmySentRequest(userId);
		Friend frnd=new Friend();
		if(frndrqstsend!=null){
			frnd.setErrorCode("200");
			frnd.setErrorMessage("List of sent request");
			return new ResponseEntity<List<Friend>>(frndrqstsend,HttpStatus.OK);
		}else{
			frnd.setErrorCode("404");
			frnd.setErrorMessage("No list of sent request found");
			return new ResponseEntity<List<Friend>>(frndrqstsend,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/getallmyfrndrqst/{userId}")
	public ResponseEntity <List<Friend>> listofmyFrndRqst(@PathVariable("userId") int userId){
		
		List<Friend> myfrndrqst=fDao.showmyFrndRqst(userId);
		Friend frnd=new Friend();
		if(myfrndrqst!=null){
			frnd.setErrorCode("200");
			frnd.setErrorMessage("List of your Frndsent request");
			return new ResponseEntity<List<Friend>>(myfrndrqst,HttpStatus.OK);
		}else{
			frnd.setErrorCode("404");
			frnd.setErrorMessage("No list of your  Frndsent  found");
			return new ResponseEntity<List<Friend>>(myfrndrqst,HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	
	
		
	}
	


