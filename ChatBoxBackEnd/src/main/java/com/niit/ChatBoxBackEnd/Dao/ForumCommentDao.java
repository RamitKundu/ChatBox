package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.ForumComment;

public interface ForumCommentDao {
	
	public List<ForumComment> getAllForumComment();
	public boolean addForumComment(ForumComment forumComment);
	public boolean updateForumComment(ForumComment forumComment);
	public boolean deleteForumcomment(ForumComment forumComment);
	public ForumComment getById(int forumCommentId);

}
