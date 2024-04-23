package model;
/*
 * 
 * 
 */
public class User {

	private int userId;
	private String userName;
	private String userPass;
	private String userType;
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
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @param userId
	 * @param userName
	 * @param userPass
	 * @param userType
	 */
	public User(int userId, String userName, String userPass, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userType = userType;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", userType=" + userType
				+ "]";
	}
	
}
