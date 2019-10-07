package com.laba1.Service;

import com.laba1.Entity.Rating;

import java.util.List;

public interface RatingService {
    Rating findById(int id);
    void save(Rating rating);
    void update(Rating rating);
    void delete(Rating rating);
    Rating findByLogin(String login);
    List<Rating> findAll();
}
