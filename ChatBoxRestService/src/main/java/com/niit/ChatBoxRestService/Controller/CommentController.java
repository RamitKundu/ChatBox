package com.niit.ChatBoxRestService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ChatBoxBackEnd.Dao.CommentDao;
import com.niit.ChatBoxBackEnd.Model.Blog;
import com.niit.ChatBoxBackEnd.Model.Comments;
import com.niit.ChatBoxBackEnd.Model.User;

@RestController
public class CommentController {
	
	@Autowired
	CommentDao cmmntDao;

	@Autowired
	Blog blog;
	
	@Autowired
	User user;
	
	Comments cmmnt;
	
	@PostMapping("/addcomments")
	public ResponseEntity<Comments> addComment(@RequestBody Comments cmmnt){
		cmmntDao.save(cmmnt);
//		cmmnt.setBlog(blog);
//		cmmnt.setUser(user);
		return new ResponseEntity<Comments>(cmmnt,HttpStatus.OK);
	
	}
	
	@GetMapping("/allcomments")
	public ResponseEntity<List<Comments>> listComments(){
		List<Comments> listofComments=cmmntDao.getAllComments();
		return new ResponseEntity <List<Comments>>(listofComments,HttpStatus.OK);
		
	}
	

//	@GetMapping("/getcommentblogid/{blogId}")
//	public ResponseEntity <List<Comments>> getBlogByUserID(@PathVariable("blogId")int blogId){
//		List<Comments> cmmntbyblogId=cmmntDao.getByBlogId(blogId);
//		//session.getAttribute("userId");
//		
//		return new ResponseEntity<List<Comments>>(cmmntbyblogId,HttpStatus.OK);	
//			
//		}

}
