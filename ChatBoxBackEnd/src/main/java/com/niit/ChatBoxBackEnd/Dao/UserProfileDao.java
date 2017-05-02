package com.niit.ChatBoxBackEnd.Dao;

import java.util.List;

import com.niit.ChatBoxBackEnd.Model.UserProfile;

public interface UserProfileDao {
	public List<UserProfile> getAll();
	public boolean addUserProfile(UserProfile userProfile);
	public boolean updateUserProfile(UserProfile userProfile);
	public boolean deleteUserProfile(UserProfile userProfile);
	public UserProfile getById(int profileId);
	

}
