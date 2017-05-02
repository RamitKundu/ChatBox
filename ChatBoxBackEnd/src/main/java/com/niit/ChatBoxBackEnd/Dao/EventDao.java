package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.Event;

public interface EventDao {

	public List<Event> getAllEvent();
	public boolean addEvent(Event event);
	public boolean updateEvent(Event event);
	public boolean deleteEvent(Event event);
	public Event getById(int eventId);
	
}
