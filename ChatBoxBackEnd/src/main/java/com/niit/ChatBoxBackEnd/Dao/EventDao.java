package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.Event;

public interface EventDao {
	
	public boolean save(Event event);
	 public List<Event> getAllEvent();
	

}
