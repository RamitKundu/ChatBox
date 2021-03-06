package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.Friend;


public interface FriendDao {
	public boolean addFreind(Friend friend);
	public boolean updateFriend(Friend friend);
	public Friend getByid(int fId,int uId);
	public List<Friend> getmyFriends(int userId);
	public List<Friend> getmySentRequest(int userId);
	public List<Friend> showmyFrndRqst(int userId);

}
