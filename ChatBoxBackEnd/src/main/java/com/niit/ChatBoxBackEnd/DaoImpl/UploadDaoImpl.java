/*package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.UploadDao;
import com.niit.ChatBoxBackEnd.Model.Upload;

@Transactional
@Repository
public class UploadDaoImpl implements UploadDao {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUpload(Upload upload) {
		
		try {
			sessionFactory.getCurrentSession().save(upload);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Upload> getById(int uploadId) {
		
		return sessionFactory.getCurrentSession().createQuery("from Upload where uploadId='"+uploadId+"'").list();
	}

}
*/