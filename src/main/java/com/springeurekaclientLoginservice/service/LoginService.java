package com.springeurekaclientLoginservice.service;

import org.springframework.stereotype.Service;


import com.springeurekaclientLoginservice.dto.LoginDto;
import com.springeurekaclientLoginservice.dto.LoginResponseDto;
import com.springeurekaclientLoginservice.dto.ResponseDto;
import com.springeurekaclientLoginservice.entity.LoginDetails;


public interface LoginService {
	
	public ResponseDto saveLoginDetails(LoginDto loginDto);
	public LoginResponseDto userLogin(LoginDto loginRequestDto);

}
