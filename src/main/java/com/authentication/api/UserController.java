package com.authentication.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.models.User;
import com.authentication.models.UserData;
import com.authentication.models.ValidInvalidUserResponse;
import com.authentication.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService ;

	@GetMapping(value = "/user/all")
	public ResponseEntity<List<User>> getAllUser(){
		System.out.println("In user url method");
		List<User> userList = userService.getAllUser();
		if (userList != null) {
			return new ResponseEntity<List<User>>(userList, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
		
	
	@GetMapping(value = "/user/")
	public ResponseEntity<ValidInvalidUserResponse> getUserById(@RequestParam(name="username", required = true) String userId, @RequestParam(name="password", required = true) String password){
		System.out.println("In user url method");
		ValidInvalidUserResponse validInvalidUserResponse = userService.getUserById(userId, password);
		
		if (validInvalidUserResponse.isAuthenticated()== true) {
			return new ResponseEntity<ValidInvalidUserResponse>(validInvalidUserResponse, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ValidInvalidUserResponse>(validInvalidUserResponse, HttpStatus.OK);
	}
	
	

	@GetMapping(value = "/user/all/info")
	public ResponseEntity<List<UserData>> getUserDatails(){
		
		List<UserData> userList = userService.getAllUserDetails();
		if (userList != null) {
			return new ResponseEntity<List<UserData>>(userList, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserData>>(userList, HttpStatus.OK);
	}
	
	
	
}
