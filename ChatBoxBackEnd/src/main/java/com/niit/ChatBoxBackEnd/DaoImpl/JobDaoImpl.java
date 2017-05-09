package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import com.niit.ChatBoxBackEnd.Dao.JobDao;
import com.niit.ChatBoxBackEnd.Model.Job;
import com.niit.ChatBoxBackEnd.Model.JobApplication;

public class JobDaoImpl implements JobDao{

	public List<Job> getAllOpenJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	public Job getJobById(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateJob(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addJob(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addJob(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Job> getAppliedJobs(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public JobApplication getJobApplication(int userId, int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	public JobApplication getJobApplication(int jobAppId) {
		// TODO Auto-generated method stub
		return null;
	}

}
