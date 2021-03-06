package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.BlogDao;
import com.niit.ChatBoxBackEnd.Model.Blog;
import com.niit.ChatBoxBackEnd.Model.User;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	User user;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Blog> getAllBlog() {

		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}

	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Blog getById(int blogId) {
		return (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);
	}

//	public Blog getByIdandStatus(){
//		return sessionFactory.getCurrentSession().createQuery("from Blog where blogId='"+blogId+"' and status=New and )
//	}
//	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Blog> getByUserId(int userId) {
		return (List<Blog>) sessionFactory.getCurrentSession().createQuery("from Blog where user.userId='"+userId+"'").list();
				

	}

}
