package com.springeurekaclientLoginservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springeurekaclientLoginservice.dto.LoginDto;
import com.springeurekaclientLoginservice.entity.LoginDetails;
import com.springeurekaclientLoginservice.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService  {
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public LoginDetails saveLoginDetails(LoginDto loginDto) {
		LoginDetails loginDetails =  new LoginDetails();
		
		loginDetails.setEmail(loginDto.getEmail());
		loginDetails.setPassword(loginDto.getPasswords());
		
		return loginRepository.save(loginDetails);
	}

	
}
