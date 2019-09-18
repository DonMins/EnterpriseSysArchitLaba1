package com.laba1.Bean;

import com.laba1.Dao.RatingDaoImpl;
import com.laba1.Dao.UserDaoImpl;
import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "RegisterServlet", urlPatterns = "/userRegister")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        UserDaoImpl userDao = new UserDaoImpl();
        RatingDaoImpl ratingDao = new RatingDaoImpl();

        if(req.getParameter("newPassword").equals(req.getParameter("confirmPassword"))){
            String passwordBase64 = Base64.encodeBase64String(req.getParameter("newPassword").getBytes());
            System.out.println(passwordBase64);

            User user = new User(req.getParameter("newLogin"),passwordBase64,"0000");
            Rating rating = new Rating(0,0,user);

            userDao.save(user);
            ratingDao.save(rating);

            session.setAttribute("confirmerror",false);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("game.jsp");
            requestDispatcher.forward(req, resp);

        }else{
            session.setAttribute("confirmPassword",true);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("autorization.jsp");
            requestDispatcher.forward(req, resp);

        }


    }

}
