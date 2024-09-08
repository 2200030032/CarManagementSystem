package com.klef.ep.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User
{

	@Id
	@Column(name = "ausername")
	private String username;
	
	@Column(name = "aemail",unique = true,nullable = false)
	private String email;
	
	@Column(name = "apassword",length = 12,nullable = false)
	private String password;
	
	@Column(name = "repassword",length = 12,nullable = false)
	private String repassword;
	
	@Column(name="phone_no",length = 15,unique = true,nullable = false)
	private String phoneno;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	
	
}
