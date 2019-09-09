package com.laba1.Bean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.laba1.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("uname");
        System.out.println(uname);
        String pwd = request.getParameter("pwd");
        try {
            SessionFactory sf =  new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sf.openSession();

            User sub = new User();
            sub.setLogin(uname);
            sub.setPassword(pwd);
            s.beginTransaction();
            s.save(sub);
            s.getTransaction().commit();
            s.close();
            sf.close();
            out.println( "<h3>[" + uname + "] has been registered successfully!</h3>");
        }
        catch(Exception ex) {
            out.println("<h3>[" + uname + "] could NOT be registered!</h3>");
            System.out.println(ex.getMessage());
        }
    }
}