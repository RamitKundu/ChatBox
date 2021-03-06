package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.JobDao;
import com.niit.ChatBoxBackEnd.Model.Job;
import com.niit.ChatBoxBackEnd.Model.JobApplication;

@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Job> getAllOpenJobs() {
		
		return sessionFactory.getCurrentSession().createQuery("from Job").list() ;
	}

	public Job getJobById(int jobId) {
		
		return sessionFactory.getCurrentSession().get(Job.class, jobId);
	}

	public boolean updateJob(Job job) {
		try{
			 sessionFactory.getCurrentSession().update(job);;
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
		
		
	}

	public boolean updateJob(JobApplication jobApplication) {
		try{
			 sessionFactory.getCurrentSession().update(jobApplication);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean addJob(Job job) {
		try{
			 sessionFactory.getCurrentSession().save(job);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean addJob(JobApplication jobApplication) {
		try{
			 sessionFactory.getCurrentSession().save(jobApplication);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	//@SuppressWarnings("unchecked")
	public List<Job> getAppliedJobs(int userId) {
		
		return sessionFactory.getCurrentSession().createQuery("from JobApplication where user.userId='"+userId+"'").list();
	}

	public JobApplication getJobApplication(int userId, int jobId) {
		
		return (JobApplication) sessionFactory.getCurrentSession().createQuery("from JobApplication where userId=? and jobId=?").setParameter(0, userId).setParameter(1, jobId);
	}

	public JobApplication getJobApplicationById(int jobAppId) {
	
		return sessionFactory.getCurrentSession().get(JobApplication.class, jobAppId);
	}

	public List<JobApplication> showJobsAdmin() {
		
		return sessionFactory.getCurrentSession().createQuery("from JobApplication where status='A'").list();
	}

	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<JobApplication> getUserByJobId(int jobId) {
		
		return sessionFactory.getCurrentSession().createQuery("from JobApplication where job.jobId='"+jobId+"'").list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<JobApplication> getMyAppliedJob() {
		
		return sessionFactory.getCurrentSession().createQuery("from JobApplication").list();
	}

	
	
}
