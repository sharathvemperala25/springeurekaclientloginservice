package com.springeurekaclientLoginservice.service;

import org.springframework.stereotype.Service;


import com.springeurekaclientLoginservice.dto.LoginDto;
import com.springeurekaclientLoginservice.entity.LoginDetails;


public interface LoginService {
	
	public LoginDetails saveLoginDetails(LoginDto loginDto);

}
