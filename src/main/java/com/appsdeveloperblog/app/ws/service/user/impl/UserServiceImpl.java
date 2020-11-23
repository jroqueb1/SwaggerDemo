package com.appsdeveloperblog.app.ws.service.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.Utils;
import com.appsdeveloperblog.app.ws.models.request.UserDetailRequestModel;
import com.appsdeveloperblog.app.ws.models.response.UserRest;
import com.appsdeveloperblog.app.ws.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	
	@Override
	public UserRest createUser(UserDetailRequestModel userDetail) {
		String userId = utils.generateUserId();
		UserRest user = new UserRest();
		user.setFirstName(userDetail.getFirstName());
		user.setLastName(userDetail.getLastName());
		user.setEmail(userDetail.getEmail());
		user.setUserId(userId);
		
		if(users == null)
			users  = new HashMap<>();
				
		users.put(userId, user);
				
		return user;
	}

}
