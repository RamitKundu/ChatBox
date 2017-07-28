package com.niit.ChatBoxBackEnd.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Forum {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int forumId;
	private String title;
	private String description;
	private Date dateTime;
	
	@ManyToOne
	private User user;
	@JsonManagedReference(value="forum_cmmnt movement")
	@OneToMany(fetch=FetchType.EAGER,mappedBy="forum")
	private Set<ForumComment> forum_comments=new HashSet<ForumComment>();

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ForumComment> getForum_comments() {
		return forum_comments;
	}

	public void setForum_comments(Set<ForumComment> forum_comments) {
		this.forum_comments = forum_comments;
	}
	
	
	

}