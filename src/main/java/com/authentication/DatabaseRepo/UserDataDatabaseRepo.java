package com.authentication.DatabaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.authentication.models.UserData;


public interface UserDataDatabaseRepo extends JpaRepository<UserData,String> {
	

}


