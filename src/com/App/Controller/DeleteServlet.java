package com.App.Controller;

import com.App.Service.PersonService;
import com.App.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by forteeninches on 8/07/16.
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        UserService userService = new UserService();

        String message = "";

        PersonService personService = new PersonService();
        if(personService.delete(id)){
            message = "Successfully Deleted";
        }else {
            message = "Delete Unsuccessful";
        }

        request.setAttribute("message",message);
        request.setAttribute("personList",userService.getPersonList());

        request.getRequestDispatcher("/dashboard.jsp").forward(request,response);

    }
}
