package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.Job;
import com.niit.ChatBoxBackEnd.Model.JobApplication;

public interface JobDao {
	
	public List<Job> getAllOpenJobs();
	public Job getJobById(int jobId);
	public boolean updateJob(Job job);
	public boolean updateJob(JobApplication jobApplication);
	public boolean addJob(Job job);
	public boolean addJob(JobApplication jobApplication);
	public List<Job> getAppliedJobs(int userId);
	public JobApplication getJobApplication(int userId,int jobId);
	public JobApplication getJobApplicationById(int jobAppId);
	public List<JobApplication> getUserByJobId(int jobId);
	public List<JobApplication> showJobsAdmin();
    public List<JobApplication> getMyAppliedJob();
}
