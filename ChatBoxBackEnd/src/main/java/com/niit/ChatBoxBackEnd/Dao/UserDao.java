package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.User;

public interface UserDao {
	
	public List<User> getAllUser();
	public User getById(int userId);
	public User getByEmail(String email);
	public boolean add(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User validate(String email,String password);
	public void setOnline(int userId);
	public void setOffline(int userId);
    
}
