package com.laba1.Dao;

import com.laba1.Entity.Rating;

import java.util.List;
/**
 * DAO интерфейс для работы с таблицей Rating
 * @author Maks
 * @version 1.1
 */
public interface RatingDao {
    Rating findById(int id);
    void save(Rating rating);
    void update(Rating rating);
    void delete(Rating rating);
    Rating findByLogin(String login);
    List<Rating> findAll();
}
