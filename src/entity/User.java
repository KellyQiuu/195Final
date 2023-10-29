package src.entity;

import java.util.ArrayList;

/**
 * This entity User is a class that represent the User in this program.
 */

public class User {
    private final String username;
    private final String password;

    private final String email;

    private ArrayList<String> course_list;

    /**
     * @param username   the username of the new user
     * @param password   the password of the new user
     * @param email  the email of the new user
     * @param courseList  an ArrayList of course of the new user
     */


    protected User(String username, String password, String email, ArrayList<String> courseList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.course_list = courseList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail(){
        return email;
    }
    public ArrayList<String> getCourse_list(){
        return course_list;
    }
}