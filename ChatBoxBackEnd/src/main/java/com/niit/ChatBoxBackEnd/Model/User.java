 package com.niit.ChatBoxBackEnd.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
@Entity
@Table(name="UserDetail")
public class User extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	private String fullName;
	@Column(unique=true)
	private String userName;
	private String password;
	private String role;
	@Column(unique=true)
	private String email;
	private String isOnline;
	private String status;
    
	//private String name;
	
//	
//	@Transient
//	MultipartFile file;
	
	@JsonManagedReference(value="user_userprofile movement")
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST,mappedBy="user")
	private UserProfile userProfile;
	
//	@JsonManagedReference(value="user_blog movement")
//	@OneToMany(fetch=FetchType.EAGER,mappedBy="user",cascade=CascadeType.ALL)
//	private Set<Blog> blog=new HashSet<Blog>();
//	
//	
//	
//	public Set<Blog> getBlog() {
//		return blog;
//	}
//	public void setBlog(Set<Blog> blog) {
//		this.blog = blog;
//	}
	
	
	
//	
//	public MultipartFile getFile() {
//		return file;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setFile(MultipartFile file) {
//		this.file = file;
//	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public long getContact() {
//		return contact;
//	}
//	public void setContact(long contact) {
//		this.contact = contact;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	public String getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	
	
	

}
