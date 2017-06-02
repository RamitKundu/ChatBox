package com.niit.ChatBoxBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ChatBoxBackEnd.Dao.BlogDao;
import com.niit.ChatBoxBackEnd.Dao.CommentDao;
import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.Blog;
import com.niit.ChatBoxBackEnd.Model.Comments;
import com.niit.ChatBoxBackEnd.Model.User;

public class CommentTestCase {

	@Autowired
	private static Comments comments;
	@Autowired
	private static CommentDao commentDao;
	@SuppressWarnings("unused")
	@Autowired
	private static User user;
	@Autowired
	private static UserDao userDao;
	@Autowired
	private static Blog blog;
	@Autowired
	private static BlogDao blogDao;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		comments = (Comments) context.getBean("comments");
		user = (User) context.getBean("user");
		blog = (Blog) context.getBean("blog");
		blogDao = (BlogDao) context.getBean("blogDao");
		userDao = (UserDao) context.getBean("userDao");
		commentDao = (CommentDao) context.getBean("commentDao");

	}

	@Test
	public void addComment() {
		comments.setCommentDsp("ABCDEfhghg");
		comments.setBlog(blogDao.getById(75));
		comments.setUser(userDao.getById(71));
		boolean flag = commentDao.save(comments);
		assertEquals("addComment", true, flag);
	}

}
