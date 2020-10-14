package com.example.ApiUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<User> users(){
		return (List<User>) userDao.findAll();
	}
	
	@RequestMapping(value="/getUserbyname", method=RequestMethod.GET)
	public List<User> user(@RequestParam(name = "name", required = true, defaultValue = "id")String name){
		return (List<User>) userDao.findBynom(name);
	}
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User adduser(@RequestBody User newUser){
		return userDao.save(newUser);
	}
	
	
	
	

}
