package com.laba1.Bean;

import com.laba1.Dao.UserDaoImpl;
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
@WebServlet(name = "UserServlet", urlPatterns = "/userLogin")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        UserDaoImpl userDao = new UserDaoImpl();
        String passwordBase64 = Base64.encodeBase64String(req.getParameter("password").getBytes());
        User user= new User(req.getParameter("login"),passwordBase64,"0000");

        System.out.println(user.getLogin()); // вывод того что ввели

        if (userDao.findByLogin(user.getLogin())== null){
            session.setAttribute("errorlogin",true);
            session.setAttribute("userIn",null);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("autorization.jsp");
            requestDispatcher.forward(req, resp);

        }else if( (userDao.findByLogin(user.getLogin()).getPassword()).equals(user.getPassword())){
            session.setAttribute("errorpassword",null);
            session.setAttribute("errorlogin",null);
            session.setAttribute("userIn",true);
            session.setAttribute("userLogin",user.getLogin());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("autorization.jsp");
            requestDispatcher.forward(req, resp);
        } else{
            session.setAttribute("errorpassword",true);
            session.setAttribute("userIn",null);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("autorization.jsp");
            requestDispatcher.forward(req, resp);
        }



    }

    }
