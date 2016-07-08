package com.App.Controller;

import com.App.Modal.User;
import com.App.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by forteeninches on 8/07/16.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        UserService userService = new UserService();

        String message = userService.auth(user);
        String mess = "";

        if(message.equals("successful")){
            HttpSession session = request.getSession();
            session.setAttribute("username",request.getParameter("username").toUpperCase());
            request.setAttribute("personList",userService.getPersonList());
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        }
        else if(message.equals("failed")){
            mess = "Login Failed";
            request.setAttribute("message",mess);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        request.setAttribute("personList",userService.getPersonList());

        request.getRequestDispatcher("/dashboard.jsp").forward(request,response);
    }
}
