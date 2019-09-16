package com.springeurekaclientLoginservice.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springeurekaclientLoginservice.dto.LoginDto;
import com.springeurekaclientLoginservice.dto.LoginResponseDto;
import com.springeurekaclientLoginservice.dto.ResponseDto;
import com.springeurekaclientLoginservice.entity.LoginDetails;
import com.springeurekaclientLoginservice.exception.InvalidLoginException;
import com.springeurekaclientLoginservice.repository.LoginRepository;
import com.springeurekaclientLoginservice.utils.LeaveUtil;

@Service
public class LoginServiceImpl implements LoginService  {
	
	@Autowired
	LoginRepository loginRepository;

	@Override
	public ResponseDto saveLoginDetails(LoginDto loginDto) {
		LoginDetails loginDetails =  new LoginDetails();
		
		loginDetails.setEmail(loginDto.getEmail());
		loginDetails.setPassword(loginDto.getPasswords());
		LoginDetails loginDetailsReturned = loginRepository.save(loginDetails);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setEmail(loginDetailsReturned.getEmail());
		responseDto.setLoginId(loginDetailsReturned.getLoginId());
		responseDto.setPassword(loginDetails.getPassword());
		responseDto.setRegId(loginDetailsReturned.getRegId());
		
		return responseDto ;
	}

	
	@Override

	public LoginResponseDto userLogin(LoginDto loginRequestDto)  {

	

	//	logger.info("in userlogin service");

		String userEmail = loginRequestDto.getEmail();

		if (userEmail.length() <= 8)

			throw new InvalidLoginException(LeaveUtil.INVALID_DOMAIN);

		String emailName = userEmail.substring(0, (userEmail.length() - 1) - 7);

		String emailDomain = userEmail.substring(emailName.length(), userEmail.length());

		

		if (!emailDomain.equals("@hcl.com"))

			throw new InvalidLoginException(LeaveUtil.INVALID_DOMAIN);



		LoginResponseDto loginResponseDto = new LoginResponseDto();

		Optional<LoginDetails> employee = loginRepository.findByEmail(userEmail);
		


		if (!employee.isPresent())

			throw new InvalidLoginException(LeaveUtil.USER_NOT_FOUND);



		if (employee.get().getEmail().equals(loginRequestDto.getEmail())

				&& employee.get().getPassword().equals(loginRequestDto.getPasswords())) {

					loginResponseDto.setMessage(employee.toString() + LeaveUtil.USER_FOUND);

					loginResponseDto.setStatus(LeaveUtil.LOGIN_STATUS);



		} else {

			loginResponseDto.setMessage(LeaveUtil.INVALID_DETAILS);

			loginResponseDto.setStatus(LeaveUtil.Failure_STATUS);

			loginResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());

		}



		return loginResponseDto;

	}
}
