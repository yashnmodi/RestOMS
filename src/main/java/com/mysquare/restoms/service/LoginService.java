package com.mysquare.restoms.service;

import com.mysquare.restoms.model.LoginDetails;
import com.mysquare.restoms.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;
	
	public LoginDetails getValidRole(String uname, String password) {
		LoginDetails loginDetails = loginRepo.getValidRoleDao(uname,password);
		return loginDetails;
	}
	
}
