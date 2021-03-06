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
	private static User user;
	@Autowired
	private static UserDao userDao;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");
		userDao = (UserDao) context.getBean("userDao");

	}

	 @Test
	 public void addUserTestCase(){
	 //user.setUserId(1);
	 user.setFullName("Anand");
	 user.setPassword("125");
	 //user.setAddress("abcde");
	 //user.setContact(12345);
	 user.setEmail("abcd");
	 user.setIsOnline("A");
	 user.setRole("user");
	 user.setStatus("New");
	// user.setErrorCode("200");
	// user.setErrorMessage("user created");
	
	 boolean flag=userDao.add(user);
	 assertEquals("addUserTestCase",true,flag);
	
	 }
	 @Test
	 public void updateUserTestCase(){
	
	 user.setUserId(31);
	 user.setFullName("Arnab Sarkar");
	 user.setPassword("123");
//	 user.setAddress("abcd");
//	 user.setContact(12345);
	 user.setEmail("abcd");
	 user.setIsOnline("A");
	 user.setRole("user");
	 user.setStatus("Accept");
	
	 boolean flag=userDao.update(user);
	 assertEquals("updateUserTestCase",true,flag);
	 }
	
	 @Test
	 public void validateUserTestCase(){
	 user=userDao.validate("abcd", "12kfej");
	 assertEquals("validateUserTestCase",true,user);
	 }
	
	 @Test
	 public void deleteUserTestCase(){
	
	 user.setUserId(28);
	 user.setFullName("Anand");
	 user.setPassword("125");
//	 user.setAddress("abcde");
//	 user.setContact(12345);
	 user.setEmail("abcd");
	 user.setIsOnline("A");
	 user.setRole("user");
	 user.setStatus("Accept");
	
	 boolean flag=userDao.delete(user);
	 assertEquals("deleteUserTestCase",true,flag);  
	 }
	
	
	 @Test
	 public void getAllUserTestCase(){
	 int size=userDao.getAllUser().size();
	 assertEquals("getAllUserTestCase",4,size);
	
	 }
	@Test
	public void getByEmailTestCase() {
		int flag = 0;
		User user = userDao.getByEmail("abcdjhjk");
		if (user != null) {
			flag++;
			assertEquals("getByEmailTestCase", 1, flag);
		} else {
			assertEquals("getByEmailTestCase", 0, flag);

		}
	}

}
