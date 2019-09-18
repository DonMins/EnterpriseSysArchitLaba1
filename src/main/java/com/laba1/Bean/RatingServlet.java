package com.laba1.Bean;

import com.laba1.Dao.RatingDaoImpl;
import com.laba1.Entity.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Сервлет для работы с рейтингом игроков
 *
 * @author Maks
 */

public class RatingServlet  {

    public Map<Double, String> rating() {
        RatingDaoImpl ratingDao = new RatingDaoImpl();
        List<Rating> ratingList = ratingDao.findAll();
        // Создаем map с именем пользователя и его рейтингом и сразу отсортировываем по убыванию
        Map<Double, String> map = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                if (a >= b) {
                    return 1;
                } else if (a < b)
                    return -1;
                else
                    return 0;
            }
        });
        // Пользователи с 0  getCountgame() не будут отображаться в списке
        for (Rating rating : ratingList) {
            map.put((double) rating.getAllAttempt() / rating.getCountgame(), rating.getUsers().getLogin());
        }
        return map;
    }
}
