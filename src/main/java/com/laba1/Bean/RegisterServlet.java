package com.laba1.Bean;

import com.laba1.Dao.UserDaoImpl;
import com.laba1.Entity.User;
import lombok.var;

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

        if(req.getParameter("newpassword").equals(req.getParameter("confirmPassword"))){


            System.out.println(req.getParameter("newlogin"));
            System.out.println(req.getParameter("newpassword"));

            User user = new User(req.getParameter("newlogin"),req.getParameter("newpassword"),"0000");

            userDao.save(user);
            session.setAttribute("confirmerror",false);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("game.jsp");
            requestDispatcher.forward(req, resp);

        }else{
            session.setAttribute("confirmerror",true);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
            requestDispatcher.forward(req, resp);

        }


    }

}
