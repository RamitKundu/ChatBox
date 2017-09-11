package com.niit.ChatBoxBackEnd.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component("jobapp")
@Entity
public class JobApplication extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int jobAppId;
	//private int userId;
	//private int jobId;
	//private String qualification;
	
	private Date dateApplied;
	private String remarks;
	private String status;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Job job;
	
	
	
	
	
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getJobAppId() {
		return jobAppId;
	}
	public void setJobAppId(int jobAppId) {
		this.jobAppId = jobAppId;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public int getJobId() {
//		return jobId;
//	}
//	public void setJobId(int jobId) {
//		this.jobId = jobId;
//	}
	public Date getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public String getQualification() {
//		return qualification;
//	}
//	public void setQualification(String qualification) {
//		this.qualification = qualification;
//	}
	
	
	

}
