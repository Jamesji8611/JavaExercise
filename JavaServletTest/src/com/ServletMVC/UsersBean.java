package com.ServletMVC;

public class UsersBean {
	
	private int UserID;
	private String UserName;
	private String Password;
	private String Email;
	private String CustomLevel;
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCustomLevel() {
		return CustomLevel;
	}
	public void setCustomLevel(String customLevel) {
		CustomLevel = customLevel;
	}
	
	
}
