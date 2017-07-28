package com.niit.ChatBoxBackEnd.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Friend extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int friendId;
	@OneToOne
	private User user;
	@OneToOne
	private User friend;
	private int initiator;
	private String status;
	
	

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	public int isInitiator() {
		return initiator;
	}

	public void setInitiator(int initiator) {
		this.initiator = initiator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
