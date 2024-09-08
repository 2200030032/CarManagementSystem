package com.klef.ep.service;

import java.util.List;

import com.klef.ep.models.User;

public interface UserService 
{
   public String registrationUser(User user);
   
   public  User checkUserLogin(String username,String password);
   
   public List<User> viewallusers();
   
}
