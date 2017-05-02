package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.Friend;

public interface FriendDao {
	
	public List<Friend> getAllFriend();
	public boolean addFriend(Friend friend);
	public boolean deleteFriend(Friend friend);
	public boolean updateFriend(Friend friend);
	public Friend getById(int id);

}
