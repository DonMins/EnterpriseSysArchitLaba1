package com.laba1.Service;


import com.laba1.Dao.RatingDao;
import com.laba1.Entity.Rating;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;


@Stateless(name = "RatingServiceImpl")

public class RatingServiceImpl implements RatingService {

    @EJB(beanName = "RatingDaoImpl")
    private RatingDao ratingDao;

    @Override
    public Rating findById(int id) {
        return ratingDao.findById(id);
    }

    @Override
    public void save(Rating rating) {
        ratingDao.save(rating);
    }

    @Override
    public void update(Rating rating) {
        ratingDao.update(rating);
    }

    @Override
    public void delete(Rating rating) {
        ratingDao.delete(rating);
    }

    @Override
    public Rating findByLogin(String login) {
        return ratingDao.findByLogin(login);
    }

    @Override
    public List<Rating> findAll() {
        return ratingDao.findAll();
    }
}
