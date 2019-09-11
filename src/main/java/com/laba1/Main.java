package com.laba1;

import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.service.RatingService;
import com.laba1.service.UserService;

public class Main {
    public static void main(String ar[]){
        UserService userService = new UserService();
        User user = new User("1", "6");
        userService.saveUser(user);
        RatingService ratingService = new RatingService();
        Rating rating = new Rating(1,"3");
        ratingService.saveRating(rating);
    }
}
