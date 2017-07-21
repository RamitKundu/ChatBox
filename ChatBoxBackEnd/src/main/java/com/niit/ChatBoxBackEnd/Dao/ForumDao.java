package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.Forum;

public interface ForumDao {
	
	public boolean addForum(Forum forum);
	public List<Forum> getallForum();

}
