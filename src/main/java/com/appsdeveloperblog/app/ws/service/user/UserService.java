package com.appsdeveloperblog.app.ws.service.user;

import com.appsdeveloperblog.app.ws.models.request.UserDetailRequestModel;
import com.appsdeveloperblog.app.ws.models.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailRequestModel userDetail);

}
