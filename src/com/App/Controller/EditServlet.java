package com.App.Controller;

import com.App.Modal.Person;
import com.App.Service.PersonService;
import com.App.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Created by forteeninches on 8/07/16.
 */
@WebServlet(name = "EditServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)

public class EditServlet extends HttpServlet {

    private static final String save_dir="person_images";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String savePath = "/Users/forteeninches/IdeaProjects/DWITCARD/web" + File.separator + save_dir;

        File fileSaveDir = new File(savePath);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }

        String id = request.getParameter("p_id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String program = request.getParameter("program");
        String validityDate = request.getParameter("validityDate");
        String rollNumber = request.getParameter("rollNumber");
        String batch = request.getParameter("batch");

        Part part=request.getPart("file");
        System.out.println(part);
        String fileName= extractFileName(part);
        part.write(savePath + File.separator + fileName);

        Person person = new Person(firstName,lastName,city,district,program,validityDate,rollNumber,fileName,batch);

        PersonService personService = new PersonService();
        String message = "";

        if(personService.update(person, id)){
            message = "Successfully Updated";
        }
        else {
            message = "Update Unsuccessful";
        }

        UserService userService = new UserService();
        request.setAttribute("message",message);
        request.setAttribute("personList",userService.getPersonList());

        request.getRequestDispatcher("/dashboard.jsp").forward(request,response);

    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String p_id = request.getParameter("id");
        PersonService personService = new PersonService();

        request.setAttribute("person",personService.edit(p_id));

        request.getRequestDispatcher("/edit.jsp").forward(request,response);

    }
}
