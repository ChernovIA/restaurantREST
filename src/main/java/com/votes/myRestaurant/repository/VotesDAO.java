package com.votes.myRestaurant.repository;

import com.votes.myRestaurant.model.User;
import com.votes.myRestaurant.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
@Transactional(readOnly = true)
public interface VotesDAO extends JpaRepository<Vote, Long> {

    @Query("Select v from Vote as v where v.user = :user and v.date = :localDate")
    Vote getVoteByUserAndDate(@Param("user") User user, @Param("localDate") LocalDate localDate);
}
