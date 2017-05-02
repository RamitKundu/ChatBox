package com.niit.ChatBoxBackEnd.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int profileId;
	private int userId;
	private String school;
	private String collage;
	private String company;
	private float schoolmarks;
	private float collagemarks;
	
	
	
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollage() {
		return collage;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public float getSchoolmarks() {
		return schoolmarks;
	}
	public void setSchoolmarks(float schoolmarks) {
		this.schoolmarks = schoolmarks;
	}
	public float getCollagemarks() {
		return collagemarks;
	}
	public void setCollagemarks(float collagemarks) {
		this.collagemarks = collagemarks;
	}
	
	

}
