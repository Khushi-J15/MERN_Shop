package com.ecom.first.service.interf;

import com.ecom.first.dto.LoginRequest;
import com.ecom.first.dto.Response;
import com.ecom.first.dto.UserDto;
import com.ecom.first.entity.User;

public interface UserService {
	 	Response registerUser(UserDto registrationRequest);
	    Response loginUser(LoginRequest loginRequest);
	    Response getAllUsers();
	    User getLoginUser();
	    Response getUserInfoAndOrderHistory();
}
