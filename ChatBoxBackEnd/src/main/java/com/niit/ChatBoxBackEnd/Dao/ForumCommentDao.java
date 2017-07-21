package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.ForumComment;

public interface ForumCommentDao {
	
		public List<ForumComment> getAllForumCmmnt();
		public boolean addForumCmmnt(ForumComment forumCmmnt);
		//public ForumComment getByuserId(int userId);

	}



