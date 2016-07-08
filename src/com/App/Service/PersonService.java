package com.App.Service;

import com.App.Config.DatabaseConnection;
import com.App.Modal.Person;
import com.App.Modal.User;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by forteeninches on 8/07/16.
 */
public class PersonService {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement preparedStatement1 = null;
    PreparedStatement preparedStatement2 = null;
    PreparedStatement preparedStatement3 = null;
    PreparedStatement preparedStatement4 = null;
    PreparedStatement preparedStatement5 = null;
    PreparedStatement preparedStatement6 = null;

    public PersonService(){
        connection = new DatabaseConnection().getConn();
    }

    public boolean save(Person person){

        try {
            preparedStatement = connection.prepareStatement("insert into person(first_name,last_name,city,district,program,validity_date,roll_number,created_date,image,batch) values(?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setString(3,person.getCity());
            preparedStatement.setString(4,person.getDistrict());
            preparedStatement.setString(5,person.getProgram());
            preparedStatement.setString(6,person.getValidityDate());
            preparedStatement.setString(7,person.getRollNumber());
            preparedStatement.setString(8, getCurrentDate());

            if(person.getPhoto()!=null){
                preparedStatement.setString(9,person.getPhoto());
            }
            else {
                preparedStatement.setString(9,"");
            }

            preparedStatement.setString(10,person.getBatch());


            int row = preparedStatement.executeUpdate();

            if (row>0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Person edit(String id){

        Person person = new Person();

        try {
            preparedStatement3 = connection.prepareStatement("SELECT *FROM person WHERE id = ?");
            preparedStatement3.setString(1,id);

            ResultSet rs = preparedStatement3.executeQuery();

            while (rs.next()){

                person.setId(rs.getString("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setCity(rs.getString("city"));
                person.setDistrict(rs.getString("district"));
                person.setProgram(rs.getString("program"));
                person.setValidityDate(rs.getString("validity_date"));
                person.setRollNumber(rs.getString("roll_number"));
                person.setCreatedDate(rs.getString("created_date"));
                person.setUpdatedDate(rs.getString("updated_date"));
                person.setBatch(rs.getString("batch"));
                person.setPhoto(rs.getString("image"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public boolean update(Person person,String id){

        try {
            preparedStatement5 = connection.prepareStatement("UPDATE person SET first_name = ?,last_name = ?,city = ?,district = ?,program = ?,validity_date = ?,roll_number = ?, updated_date = ?,image=?,batch=? where id = ?");
            preparedStatement5.setString(1,person.getFirstName());
            preparedStatement5.setString(2,person.getLastName());
            preparedStatement5.setString(3,person.getCity());
            preparedStatement5.setString(4,person.getDistrict());
            preparedStatement5.setString(5,person.getProgram());
            preparedStatement5.setString(6,person.getValidityDate());
            preparedStatement5.setString(7,person.getRollNumber());
            preparedStatement5.setString(8,person.getUpdatedDate());

            if(person.getPhoto()!=null){
                preparedStatement5.setString(9,person.getPhoto());
            }
            else {
                preparedStatement5.setString(9,"");
            }

            preparedStatement5.setString(10,person.getBatch());
            preparedStatement5.setString(11,id);

            if(preparedStatement5.executeUpdate()>0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(String id){

        try {
            preparedStatement4 = connection.prepareStatement("DELETE FROM person WHERE id = ?");
            preparedStatement4.setString(1,id);

            File deleteFile = new File("/home/sanjeevbudha/IdeaProjects/DWITCARD/web/person_images/"+getImageName(id));

            if(preparedStatement4.executeUpdate()>0){

                if(deleteFile.exists()){
                    deleteFile.delete();
                }

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public String getCurrentDate(){

        Date currentDate = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String dateToString = format.format(currentDate);

        return dateToString;
    }

    public String getImageName(String id){

        String image = "";
        try {
            preparedStatement6 = connection.prepareStatement("select image from person where id = ?");
            preparedStatement6.setString(1,id);

            ResultSet rs = preparedStatement6.executeQuery();

            while (rs.next()){
                image = rs.getString("image");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return image;

    }

}
