package com.bo;

public class bo_class {
	private String Username;
	private int password;
	private String email;
	
	private int confirm_pass;

	
	public bo_class() {
		super();
	}
	public bo_class(String username, String email, int password, int confirm_pass) {
		super();
		Username = username;
		this.email = email;
		this.password = password;
		this.confirm_pass = confirm_pass;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getConfirm_pass() {
		return confirm_pass;
	}
	public void setConfirm_pass(int confirm_pass) {
		this.confirm_pass = confirm_pass;
	}
	public String toString() {
		return "bo_class [Username=" + Username + ", email=" + email + ", password=" + password + ", confirm_pass="
				+ confirm_pass + "]";
	}
	
}
