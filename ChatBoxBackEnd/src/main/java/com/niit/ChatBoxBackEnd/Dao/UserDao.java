package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.User;

public interface UserDao {
	
	public List<User> getAllUser();
	public User getById(int userId);
	public boolean add(User user);
	public boolean update(User user);
	public boolean validate(int userId,String password);

}
