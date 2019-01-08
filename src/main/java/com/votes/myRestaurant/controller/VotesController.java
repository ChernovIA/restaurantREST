package com.votes.myRestaurant.controller;

import com.votes.myRestaurant.dto.VoteStatisticDTO;
import com.votes.myRestaurant.repository.VotesStatistic;
import com.votes.myRestaurant.utils.ConverterFromModelToDTO;
import com.votes.myRestaurant.dto.VoteDTO;
import com.votes.myRestaurant.model.Restaurant;
import com.votes.myRestaurant.model.User;
import com.votes.myRestaurant.model.Vote;
import com.votes.myRestaurant.repository.RestaurantDAO;
import com.votes.myRestaurant.repository.VotesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/rest/votes")
public class VotesController {

    private final VotesDAO votesDAO;
    private final VotesStatistic votesStatistic;
    private final RestaurantDAO restaurantDAO;

    @Autowired
    public VotesController(VotesDAO votesDAO, RestaurantDAO restaurantDAO, VotesStatistic votesStatistic) {
        this.votesDAO = votesDAO;
        this.restaurantDAO = restaurantDAO;
        this.votesStatistic = votesStatistic;
    }

    @GetMapping("/vote/restaurant/{restaurantId}")
    public ResponseEntity<VoteDTO> addVote(@PathVariable Long restaurantId){

        User auth = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Vote vote = votesDAO.getVoteByUserAndDate(auth, LocalDate.now());

        LocalDateTime currentTime = LocalDateTime.now();

        if (currentTime.getHour() > 10 && vote != null){
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "USER already has voted!");
        }

        if (vote == null){
            vote = new Vote();
        }

        vote.setDate(LocalDate.now());
        vote.setValue(1);

        if (auth != null && auth.isEnabled()){
            vote.setUser(auth);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User is disabled, you cant vote! Please, contact the administrator!");
        }

        if (restaurantId != null) {
            Optional<Restaurant> restaurant = restaurantDAO.findById(restaurantId);
            if (restaurant.isPresent()) {
                vote.setRestaurant(restaurant.get());
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant with id = " + restaurantId + " not found!");
            }
        }

        votesDAO.save(vote);

        return ResponseEntity.ok(ConverterFromModelToDTO.convertVote(vote));
    }

    @GetMapping("/statistic/restaurant/{restaurantId}/date/{localDate}")
    public ResponseEntity<VoteStatisticDTO> getRestaurantStatistic(@PathVariable Long restaurantId, @PathVariable LocalDate localDate){

        VoteStatisticDTO voteStatisticDTO = new VoteStatisticDTO();
        if (restaurantId != null && localDate != null) {
            Optional<Restaurant> restaurant = restaurantDAO.findById(restaurantId);
            if (restaurant.isPresent()) {
                voteStatisticDTO.setRestaurant(restaurant.get().toString());
                voteStatisticDTO.setLocalDate(localDate);

                int restVotes    = votesStatistic.getRestaurantRate(restaurantId, localDate).intValue();
                int restVotesAll = votesStatistic.getAllVotes(localDate).intValue();
                voteStatisticDTO.setRate(restVotesAll == 0 ? 0f : (float) 100 * restVotes / restVotesAll);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant with id = " + restaurantId + " not found!");
            }
        }

        return ResponseEntity.ok(voteStatisticDTO);
    }

}
