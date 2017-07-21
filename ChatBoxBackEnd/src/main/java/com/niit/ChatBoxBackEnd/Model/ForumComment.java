package com.niit.ChatBoxBackEnd.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ForumComment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int forumcmmntId;
	private String cmmntDsp;
	@ManyToOne
	private User  user;
	 @JsonBackReference(value="forum_cmmnt movement")
     @ManyToOne(cascade=CascadeType.PERSIST)
	private Forum forum;

	public int getForumcmmntId() {
		return forumcmmntId;
	}

	public void setForumcmmntId(int forumcmmntId) {
		this.forumcmmntId = forumcmmntId;
	}

	public String getCmmntDsp() {
		return cmmntDsp;
	}

	public void setCmmntDsp(String cmmntDsp) {
		this.cmmntDsp = cmmntDsp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	

}
