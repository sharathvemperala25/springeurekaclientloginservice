package com.springeurekaclientLoginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springeurekaclientLoginservice.dto.LoginDto;
import com.springeurekaclientLoginservice.dto.LoginResponseDto;
import com.springeurekaclientLoginservice.dto.ResponseDto;
import com.springeurekaclientLoginservice.entity.LoginDetails;
import com.springeurekaclientLoginservice.service.LoginService;

@RestController
public class LoginController {
	
	

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")

	public ResponseEntity<LoginResponseDto> userLogin(@RequestBody LoginDto loginRequestDto){


		return new ResponseEntity<>(loginService.userLogin(loginRequestDto),HttpStatus.OK);

	}
		
		
	@PostMapping("/saveLoginDetails")
	public ResponseEntity<ResponseDto> saveLoginDetails(@RequestBody LoginDto loginDto ) {
		return new ResponseEntity<ResponseDto>(loginService.saveLoginDetails(loginDto),HttpStatus.CREATED);
	}
	

	
	
	
	@Bean

	@LoadBalanced

	public RestTemplate restTemplate() {

		return new RestTemplate();

	}

}
