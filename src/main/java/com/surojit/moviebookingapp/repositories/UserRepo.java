package com.surojit.moviebookingapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.surojit.moviebookingapp.models.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username = :username ")
	User findByUsername(@Param("username") String username);

}
