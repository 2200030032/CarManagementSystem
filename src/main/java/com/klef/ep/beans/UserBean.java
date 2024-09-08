package com.klef.ep.beans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.klef.ep.models.Employee;
import com.klef.ep.models.User;
import com.klef.ep.service.UserService;

@ManagedBean(name = "userbean",eager = true)
public class UserBean
{
   
	@EJB(lookup = "java:global/carmanagement/UserServiceImpl!com.klef.ep.service.UserService")
	UserService userservice;
	
	private List<User> userlist;
	
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String phnno;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	
	 public void validateCustomerlogin() throws IOException
	  {
	   FacesContext facesContext = FacesContext.getCurrentInstance();
	     ExternalContext externalContext = facesContext.getExternalContext();
	  
	     HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	   HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	  
	   User user = userservice.checkUserLogin(username, password);
	   
	   if(user!=null)
	   {
//	     HttpSession session = request.getSession();
//	     session.setAttribute("user", user);
	    
	     response.sendRedirect("index.html");
	   }
	   else
	   {
	    response.sendRedirect("userlogin.jsf");
	   }
	  }
	 
	 public String userregistration()
	 {
		 User user=new User();
		 
		 user.setUsername(username);
		 user.setEmail(email);
		 user.setPhoneno(phnno);
		 user.setPassword(password);
		 user.setRepassword(repassword);
		 
		 userservice.registrationUser(user);
		 
		 return "userlogin.jsf?faces-redirect=true";
	 }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnno() {
		return phnno;
	}
	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}
	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + ", repassword=" + repassword + ", email="
				+ email + ", phnno=" + phnno + "]";
	}
	
	public List<User> getuserist() {
		return userservice.viewallusers();
	}
	
	
}
