package com.laba1.Bean;

import com.laba1.Task.Task;
import lombok.var;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Пока сделал такую штуку, но ее не будем использовать, пользователь со страницы авторизации поподает на страницу Игры -
 * это главная страница на ней и будет происходить дейтсвие , просто делаем textarea и поля для ввода цифр пользователем
 * и кнопку отправить , написав число пользователь тыкае кнопку отправить и число из этого поля ajax полетело сюда и обратно же
 * вернулся ответ и вывелся в поле. Но я пока не знаю как это сделать , поэтому пусть пока так будет
 * @author Maks
 */
@WebServlet()
public class GameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        Task task = (Task) session.getAttribute("task");
        if (task != null) {
            String login = "don"; // надо передать логин пользователя который в системе, надо из сессии его получиить
            var game = new Game();
            task.setServerResponse(game.result(task.getNumber(),login));
        }
        session.setAttribute("task", task);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

}
