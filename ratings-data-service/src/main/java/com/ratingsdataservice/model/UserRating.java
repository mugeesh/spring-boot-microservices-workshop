package com.ratingsdataservice.model;

import java.util.Arrays;
import java.util.List;

public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public void initData(String userId) {
        this.setUserId(userId);
        this.setRatings(
        		Arrays.asList(
        				new Rating("597", 9),
        				new Rating("200", 4)
        				));
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
    }
