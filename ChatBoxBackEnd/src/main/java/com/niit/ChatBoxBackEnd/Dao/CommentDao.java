package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.Comments;

public interface CommentDao {
	
public List<Comments> getAllComments();
public boolean save(Comments comments);

}
