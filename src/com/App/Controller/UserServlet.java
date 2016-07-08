package com.App.Controller;

import com.App.Modal.User;
import com.App.Service.UserService;

import java.io.IOException;

/**
 * Created by forteeninches on 8/07/16.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));

        UserService userService = new UserService();

        String message = userService.register(user);
        String mess = "";

        if (message.equals("successful")){
            mess = "Successfully Added";
            request.setAttribute("addMessage",mess);
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        else if(message.equals("failed")){
            mess = "Failed Add";
            request.setAttribute("addMessage",mess);
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }



    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.sendRedirect("/register.jsp");

    }
}
