package com.laba1.Bean;

import com.laba1.Dao.RatingDaoImpl;
import com.laba1.Dao.UserDaoImpl;
import com.laba1.Entity.Rating;
import com.laba1.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Сервлет для работы с рейтингом игроков
 *
 * @author Maks
 */
public class RatingServlet  extends HttpServlet  {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("map", rating());
        req.getRequestDispatcher("rating.jsp").forward(req, resp);
    }

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
