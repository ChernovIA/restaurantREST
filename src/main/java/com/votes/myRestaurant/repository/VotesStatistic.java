package com.votes.myRestaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class VotesStatistic {

    private final EntityManager em;
    private DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    public VotesStatistic(EntityManager em) {
        this.em = em;
    }

    public BigInteger getRestaurantRate(Long restaurantId, LocalDate localDate){
        Query query = em.createNativeQuery("SELECT " +
                                            "   count(vote.value) " +
                                            "FROM votes AS vote where vote.restaurant_fk = :restId and vote.date = :localDate");
        query.setParameter("restId", restaurantId);
        query.setParameter("localDate", localDate.format(sdf));
        return (BigInteger)query.getSingleResult();
    }

    public BigInteger getAllVotes(LocalDate localDate){
        Query query = em.createNativeQuery("SELECT " +
                                        "   count(vote.value) " +
                                        "FROM votes AS vote where vote.date = :localDate");
        query.setParameter("localDate", localDate.format(sdf));
        return (BigInteger)query.getSingleResult();
    }

//    @Query("SELECT " +
//            "   rest, "+
//            "   count(vote0.value) " +
//            "FROM Vote AS vote0 left join Restaurant as rest on vote0.restaurant = rest.id " +
//            "WHERE vote0.date = :localDate GROUP BY rest")
//    public Map<String, Float> getRestaurantsRate(LocalDate localDate){
//
//    }

//    Query query = em.createNativeQuery(
//            "drop table if exists restaurant_votes;" +
//                    "drop table if exists restaurant_votes_max;" +
//                    "CREATE TEMPORARY TABLE restaurant_votes(" +
//                    "   SELECT " +
//                    "       trestaurant_fk," +
//                    "       count(vote0.value) as valueVotes" +
//                    "   FROM votes as vote0\n" +
//                    "   WHERE vote0.date = :localDate" +
//                    "   group by restaurant_fk);" +
//                    "CREATE TEMPORARY TABLE restaurant_votes_max(" +
//                    "   SELECT " +
//                    "sum(vv.valueVotes) as valueVotesMax" +
//                    "   FROM restaurant_votes as vv);" +
//                    "SELECT " +
//                    "   if (v2.valueVotesMax = 0, 0, 100*v1.valueVotes / v2.valueVotesMax) as rate " +
//                    "FROM restaurant_votes as v1" +
//                    "   left join restaurant_votes_max as v2 on true" +
//                    "   where v1.restaurant_fk = :restaurantId");
}
