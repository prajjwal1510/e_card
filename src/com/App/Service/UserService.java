package com.App.Service;

import com.App.Config.DatabaseConnection;
import com.App.Modal.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by forteeninches on 8/07/16.
 */
public class UserService {

    private Connection connection = null;
    private PreparedStatement preparedStatement1 = null;
    private PreparedStatement preparedStatement2 = null;
    private PreparedStatement preparedStatement3 = null;

    public UserService(){
        connection = new DatabaseConnection().getConn();
    }

    public String register(User user){

        try {
            preparedStatement1 = connection.prepareStatement("insert into user(username,password,email) values(?,?,?)");
            preparedStatement1.setString(1,user.getUsername());
            preparedStatement1.setString(2,user.getPassword());
            preparedStatement1.setString(3,user.getEmail());

            int var = preparedStatement1.executeUpdate();
            if(var > 0){
                return "successful";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "failed";
    }

    public String auth(User user){

        try {
            preparedStatement2 = connection.prepareStatement("select *from user WHERE username=? AND password = ?");
            preparedStatement2.setString(1,user.getUsername());
            preparedStatement2.setString(2,user.getPassword());

            ResultSet rs = preparedStatement2.executeQuery();

            while (rs.next()){
                return "successful";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "failed";
    }

    public List<Person> getPersonList(){

        List<Person> personList = new LinkedList<Person>();

        try {
            preparedStatement3 = connection.prepareStatement("select *from person");

            ResultSet resultSet = preparedStatement3.executeQuery();

            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getString("id"));
                person.setPhoto(resultSet.getString("image"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setRollNumber(resultSet.getString("roll_number"));
                person.setValidityDate(resultSet.getString("validity_date"));
                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }
}
