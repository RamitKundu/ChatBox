package com.niit.ChatBoxBackEnd.Dao;


import java.util.List;

import com.niit.ChatBoxBackEnd.Model.UserProfile;

public interface UserProfileDao {

	public boolean addUserProfile(UserProfile userProfile);
	public List<UserProfile> getallUProfile();
	public boolean updateUserProfile(UserProfile userProfile);
}
