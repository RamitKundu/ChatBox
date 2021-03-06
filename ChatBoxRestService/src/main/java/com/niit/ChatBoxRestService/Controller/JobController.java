package com.niit.ChatBoxRestService.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ChatBoxBackEnd.Dao.JobDao;
import com.niit.ChatBoxBackEnd.Model.Blog;
import com.niit.ChatBoxBackEnd.Model.Job;
import com.niit.ChatBoxBackEnd.Model.JobApplication;
import com.niit.ChatBoxBackEnd.Model.User;

@RestController
public class JobController {
	
	@Autowired
	JobDao jobDao;
	
	
	Job job;
	
	
	JobApplication jobapp;
	
	@Autowired
	private HttpSession hs;
	
	@PostMapping("/addjob")
	public ResponseEntity<Job> addJob(@RequestBody Job job){
		job.setDateTime(new Date());
		jobDao.addJob(job);
		
		return new ResponseEntity<Job>(job,HttpStatus.OK);
		
	}
	
	@GetMapping("/getalljob")
	public ResponseEntity <List<Job>> getallJob(){
		List<Job> getalljobs=jobDao.getAllOpenJobs();


		return new ResponseEntity<List<Job>>(getalljobs,HttpStatus.OK);
	}
	

	@PostMapping("/addapplyjob")
	public ResponseEntity<JobApplication> addJob(@RequestBody JobApplication jobapp){
		
		jobapp.setDateApplied(new Date());;
		jobapp.setStatus("New");
		jobDao.addJob(jobapp);
		
		return new ResponseEntity<JobApplication>(jobapp,HttpStatus.OK);
		
	}

	@GetMapping("/getjobuserid/{userId}")
	public ResponseEntity <List<Job>> getBlogByUserID(@PathVariable("userId")int userId){
		List<Job> appliedJobs=jobDao.getAppliedJobs(userId);
		
		
		return new ResponseEntity<List<Job>>(appliedJobs,HttpStatus.OK);	
			
		}
	
	@GetMapping("/getappliedjobstoadmin")
	public ResponseEntity<List<JobApplication>> getAppliedJobsToAdmin(){
		List<JobApplication> getJobs=jobDao.showJobsAdmin();
		return new ResponseEntity<List<JobApplication>>(getJobs,HttpStatus.OK);
	}
	

	@GetMapping("/getuserbyjobId/{jobId}")
	public ResponseEntity<List<JobApplication>> getUserByJobId(@PathVariable("jobId") int jobId){
		List<JobApplication> getUserbyJobID=jobDao.getUserByJobId(jobId);
		return new ResponseEntity<List<JobApplication>>(getUserbyJobID,HttpStatus.OK);
	}
	//Update of JobApplication by admin
	@PostMapping("/updateuserprofileAdmin")
	public ResponseEntity<JobApplication> updateUser(@RequestBody JobApplication jobapp) {
		
		jobDao.updateJob(jobapp);
		return new ResponseEntity<JobApplication>(jobapp, HttpStatus.OK);

	}
	
	@GetMapping("/getmyappliedjobs")
	public ResponseEntity<List<JobApplication>> getMyJob() {
		
		List<JobApplication> getmyJobs=jobDao.getMyAppliedJob();
		return new ResponseEntity<List<JobApplication>>(getmyJobs, HttpStatus.OK);

	}
	
	

}
