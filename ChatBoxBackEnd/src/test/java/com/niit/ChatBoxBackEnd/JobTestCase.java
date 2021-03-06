package com.niit.ChatBoxBackEnd;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.ChatBoxBackEnd.Dao.JobDao;
import com.niit.ChatBoxBackEnd.Dao.UserDao;

import com.niit.ChatBoxBackEnd.Model.Job;
import com.niit.ChatBoxBackEnd.Model.JobApplication;
import com.niit.ChatBoxBackEnd.Model.User;

public class JobTestCase {

	@Autowired
	private static JobApplication jobapp;
	@Autowired
	private static JobDao jobDao;
	@SuppressWarnings("unused")
	@Autowired
	private static User user;
	@Autowired
	private static UserDao userDao;
//	@Autowired
//	private static Job job;
//	

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user = (User) context.getBean("user");
		userDao = (UserDao) context.getBean("userDao");
		//job = (Job) context.getBean("job");
		jobDao = (JobDao) context.getBean("jobDao");
		jobapp = (JobApplication) context.getBean("jobapp");
		jobDao = (JobDao) context.getBean("jobDao");
		
	}

	
	  @Test public void addJobTestcase(){
	  
	 jobapp.setDateApplied(new Date());
	 //jobapp.setQualification("B.Tech");
	 jobapp.setRemarks("OverQualified");
	 jobapp.setStatus("A");
	 
	   jobapp.setUser(userDao.getById(76));
	   jobapp.setJob(jobDao.getJobById(226));
	  
	  boolean flag=jobDao.addJob(jobapp); assertEquals("addJobTestcase",true,flag);
	  
	  }
}
