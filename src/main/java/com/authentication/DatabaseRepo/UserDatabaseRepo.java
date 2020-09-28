package com.authentication.DatabaseRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.models.User;


public interface UserDatabaseRepo extends JpaRepository<User,String> {
	

	
}


