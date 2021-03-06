package com.niit.ChatBoxBackEnd.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
public class Comments {
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int commentId;
	private String commentDsp;
    
     @ManyToOne
	  private User user;
     @JsonBackReference(value="blogcomment_movement")
     @ManyToOne(cascade=CascadeType.PERSIST)
     private Blog blog;
     
     
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	public String getCommentDsp() {
		return commentDsp;
	}
	public void setCommentDsp(String commentDsp) {
		this.commentDsp = commentDsp;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	
	
}
