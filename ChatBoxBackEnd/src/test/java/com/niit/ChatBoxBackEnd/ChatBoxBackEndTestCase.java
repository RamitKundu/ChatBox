package com.niit.ChatBoxBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.User;

import junit.framework.Assert;

public class ChatBoxBackEndTestCase {
	
	
	@Autowired
	private static  User user;
	@Autowired
	private static UserDao userDao;
	
	
	@BeforeClass
	public static void init(){
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user =(User) context.getBean("user");
		userDao=(UserDao) context.getBean("userDao");
		
	}

	
@Test
public void addUserTestCase(){
	//user.setUserId(1);
	user.setName("Ramit");
	user.setPassword("123");
	user.setAddress("abcd");
	user.setContact(12345);
	user.setEmail("abcd");
	user.setIsOnline('A');
	user.setRole("user");
	user.setStatus('A');
	
	boolean flag=userDao.add(user);
	assertEquals("addUserTestCase",true,flag);
	
}
@Test
public void updateUserTestCase(){
	
	
	user.setName("Arnab");
	user.setPassword("123");
	user.setAddress("abcd");
	user.setContact(12345);
	user.setEmail("abcd");
	user.setIsOnline('A');
	user.setRole("user");
	user.setStatus('A');

	boolean flag=userDao.update(user);
	assertEquals("updateUserTestCase",true,flag);
	
}

}
