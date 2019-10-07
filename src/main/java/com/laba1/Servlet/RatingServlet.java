package com.laba1.Servlet;

import com.laba1.Entity.Rating;
import com.laba1.Service.RatingService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@WebServlet(name = "RatingServlet", urlPatterns = "/rating")
public class RatingServlet extends HttpServlet {

    @EJB(name = "RatingServiceImpl")
    private RatingService  ratingService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }


    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Rating> ratingList = ratingService.findAll();
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
        HttpSession session = req.getSession();
        session.setAttribute("map",map);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("rating.jsp");
        requestDispatcher.forward(req, resp);
    }
}
