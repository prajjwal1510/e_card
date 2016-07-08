package com.App.Controller;

import com.App.Service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by forteeninches on 8/07/16.
 */
@WebServlet(name = "IdentityCardServlet")
public class IdentityCardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        PersonService personService = new PersonService();
        request.setAttribute("person",personService.edit(id));

        request.getRequestDispatcher("/identity.jsp").forward(request,response);
    }
}
