package com.laba1.Servlet;


import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.Service.RatingService;
import com.laba1.Service.UserService;
import org.apache.commons.codec.binary.Base64;

import javax.ejb.EJB;
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

    @EJB(beanName="UserServiceImpl")
    UserService userService;

    @EJB(beanName="RatingServiceImpl")
    RatingService ratingService;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("errorlogin",null);

        if (userService.findByLogin(req.getParameter("newLogin"))!= null) {
            session.setAttribute("exist",true);
            session.setAttribute("confirmerror",null);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
            requestDispatcher.forward(req, resp);

        } else{
            if(req.getParameter("newPassword").equals(req.getParameter("confirmPassword"))){
                String passwordBase64 = Base64.encodeBase64String(req.getParameter("newPassword").getBytes());
                System.out.println(passwordBase64);
                session.setAttribute("exist",null);

                User user = new User(req.getParameter("newLogin"),passwordBase64,"0000");

                Rating rating = new Rating(0,0,user);
                userService.save(user);
                ratingService.save(rating);

                session.setAttribute("confirmerror",null);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("autorization.jsp");
                requestDispatcher.forward(req, resp);

            }
            else{
                session.setAttribute("confirmerror",true);
                session.setAttribute("exist",null);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
                requestDispatcher.forward(req, resp);
            }
        }

    }

}
