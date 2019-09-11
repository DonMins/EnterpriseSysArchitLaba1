package com.laba1.service;

import com.laba1.Dao.RatingDaoImpl;
import com.laba1.Entity.Rating;

public class RatingService extends RatingDaoImpl {

    private RatingDaoImpl ratingDao = new RatingDaoImpl();
    public RatingService(){}

    public Rating findRaring(int id) {
        return ratingDao.findById(id);
    }

    public void saveRating(Rating rating) {
        ratingDao.save(rating);
    }
}
