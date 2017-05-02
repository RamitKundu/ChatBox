package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.JobApplication;

public interface JobApplicationDao {
	
	public List<JobApplication> getAllJobApplied();
	public boolean addJobapplied(JobApplication jobApplication);
	public boolean updateJobapplied(JobApplication jobApplication);
	public boolean deleteJobapplied(JobApplication jobApplication);
	public JobApplication getById(int jobAppId );

}
