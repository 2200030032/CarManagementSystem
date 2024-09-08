package com.klef.ep.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")

public class Admin
{
	@Id
	
	@Column(name= "ausername",length = 30)
    private  String username;
	
	@Column(name = "apassword",length = 12,nullable = false)
	
    private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
