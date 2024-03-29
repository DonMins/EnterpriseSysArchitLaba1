package com.laba1.Servlet;

import com.laba1.Entity.User;
import com.laba1.Service.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet()
public class GameServlet extends HttpServlet {

    @EJB(beanName = "UserServiceImpl")
    UserService userService;

    @EJB(name = "game")
    Game game;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String inputNumber = req.getParameter("inputNumber").trim();
        resp.setContentType("text/html; charset=UTF-8");
        String login = (String) session.getAttribute("userLogin"); // надо получить имя пользователя
        User user = userService.findByLogin(login);
        if (user.getYouNumber().equals("0000")) {
            user.setYouNumber(game.genNumber());
            System.out.println("ЧИСло " + user.getYouNumber());
            userService.update(user);
        }

        OutputStream outStream = resp.getOutputStream();

        outStream.write(game.result(inputNumber, login).getBytes("UTF-8"));
        outStream.flush();
        outStream.close();
    }

}
