package com.surojit.moviebookingapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.surojit.moviebookingapp.models.UserCinema;

import jakarta.transaction.Transactional;

public interface UserCinemaRepo extends CrudRepository<UserCinema, Integer> {

	@Query("SELECT e FROM UserCinema e WHERE e.userId =?1")
	List<UserCinema> findByUserId(int userId);

	@Modifying
	@Transactional
	@Query("DELETE FROM UserCinema e WHERE e.userId =?1 and e.cinemaId=?2")
	int deleteByUserIdAndCinemaId(int userId, int cinemaId);

}
