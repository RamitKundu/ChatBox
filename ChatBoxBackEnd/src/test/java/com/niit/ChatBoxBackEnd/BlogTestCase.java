package com.niit.ChatBoxBackEnd;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.time.LocalDate;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ChatBoxBackEnd.Dao.BlogDao;
import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.Blog;
import com.niit.ChatBoxBackEnd.Model.User;

public class BlogTestCase {

	@Autowired
	private static Blog blog;
	@Autowired
	private static BlogDao blogDao;
	@SuppressWarnings("unused")
	@Autowired
	private static User user;
	@Autowired
	private static UserDao userDao;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user = (User) context.getBean("user");
		blog = (Blog) context.getBean("blog");
		blogDao = (BlogDao) context.getBean("blogDao");
		userDao = (UserDao) context.getBean("userDao");
	}

	
	  @Test public void addBlogTestcase(){
	  
	  blog.setTitle("Posting blog 100"); blog.setDescription("Hobe na blog");blog.setDateTime(new Date());
	  blog.setStatus("confirm"); blog.setReason("asdadsdfsdffef"); blog.setLikes(25);
	  blog.setViews(2345); blog.setUser(userDao.getById(76));;
	  
	  boolean flag=blogDao.addBlog(blog); assertEquals("addBlogTestcase",true,flag);
	  
	  }
	 
//
//	@Test
//	public void getBlogByUserIdTestcase() {
//
//		Set<Blog> li=(userDao.getById(24)).getBlogs();
//		
//		assertEquals("addBlogTestcase",2,li.size());
//
//	}

}
