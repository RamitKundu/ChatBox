package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.EventDao;
import com.niit.ChatBoxBackEnd.Model.Event;

@Repository
@Transactional
public class EventDaoImpl implements EventDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(Event event) {
		try {
			sessionFactory.getCurrentSession().save(event);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Event> getAllEvent() {
		
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}

	public Event getByEventId(int eventId) {
		
		return sessionFactory.getCurrentSession().get(Event.class, eventId);
	}

}
