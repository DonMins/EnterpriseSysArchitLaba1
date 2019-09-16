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
@WebServlet(name = "UserServlet", urlPatterns = "/userRegister")
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

        var user= new User(req.getParameter("login"),req.getParameter("password"),"0000");

        System.out.println(user.getLogin()); // вывод того что ввели
        System.out.println(userDao.findByLogin(user.getLogin()));

        if (userDao.findByLogin(user.getLogin())== null){
            session.setAttribute("errorlogin",true);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("autorization.jsp");
            requestDispatcher.forward(req, resp);
        }else if( (userDao.findByLogin(user.getLogin()).getPassword()).equals(user.getPassword())){
            session.setAttribute("errorpassword",false);
            session.setAttribute("errorlogin",false);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("game.jsp");
            requestDispatcher.forward(req, resp);
        } else{
            session.setAttribute("errorpassword",true);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("autorization.jsp");
            requestDispatcher.forward(req, resp);
        }



    }

}
