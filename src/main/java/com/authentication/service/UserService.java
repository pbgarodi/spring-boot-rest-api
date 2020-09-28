package com.authentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.DatabaseRepo.UserDataDatabaseRepo;
import com.authentication.DatabaseRepo.UserDatabaseRepo;
import com.authentication.constants.Constant;
import com.authentication.models.User;
import com.authentication.models.UserData;
import com.authentication.models.ValidInvalidUserResponse;


@Service
public class UserService {

	@Autowired
	UserDatabaseRepo userdatabaseRepo;
	
	@Autowired
    UserDataDatabaseRepo userDataDatabaseRepo;
	
	public UserService() {

	}

	public List<User> getAllUser() {

		List<User> userlist = userdatabaseRepo.findAll();
		return userlist;
	}

	public ValidInvalidUserResponse getUserById(String userId, String password) {
		System.out.println("In get user by id method");
		System.out.println(userId);
		System.out.println(password);
				Optional<User> user = userdatabaseRepo.findById(userId);

		if (user.isPresent() == false) {
			System.out.println("in  ispresrtt ");
			return new ValidInvalidUserResponse(Constant.USER_NOT_FOUND_MASSAGE, false);
		}

		User userData = user.get();
		System.out.println(userData);
		System.out.println(userData.getUsername());
		System.out.println(userData.getPassword());
		
		if (userId.equals(userId) & password.equals(userData.getPassword())) {

			return new ValidInvalidUserResponse(Constant.USER_FOUND_MASSAGE, true);

		} else {
			return new ValidInvalidUserResponse(Constant.INCORRECT_USERNAME_OR_PASSWORD_MASSAGE, false);
		}
	}
	
	// get all information of all user
	public List<UserData> getAllUserDetails() {

		List<UserData> userinfo = userDataDatabaseRepo.findAll();
		return userinfo;
	}


}
