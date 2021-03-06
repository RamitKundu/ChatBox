package com.niit.ChatBoxRestService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ChatBoxBackEnd.Dao.ForumCommentDao;
import com.niit.ChatBoxBackEnd.Dao.ForumDao;
import com.niit.ChatBoxBackEnd.Model.Forum;
import com.niit.ChatBoxBackEnd.Model.ForumComment;

@RestController
public class ForumController {
	
	@Autowired
	ForumDao forumDao;
	
	@Autowired
	ForumCommentDao forumCmmntDao;
	
	@PostMapping("/addforum")
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum){
		forumDao.addForum(forum);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		
	}
	
	@GetMapping("/getallforum")
	public ResponseEntity<List<Forum>> getAllForum(){
		List<Forum> allForum=forumDao.getallForum();
		return new ResponseEntity<List<Forum>>(allForum,HttpStatus.OK);
	}
	
	@PostMapping("/addforumcmmnt")
	public ResponseEntity<ForumComment> addForumCmmnt(@RequestBody ForumComment forumCmmnt){
	    forumCmmntDao.addForumCmmnt(forumCmmnt);
		return new ResponseEntity<ForumComment>(forumCmmnt,HttpStatus.OK);
		
	}
	

}
