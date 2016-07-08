package com.App.Modal;

/**
 * Created by forteeninches on 8/07/16.
 */
public class User{

    String username;
    String email;
    String password;

    public User(String username, String password,String email) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
