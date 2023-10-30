package entity;
import java.util.List;

import java.util.ArrayList;

/**
 * This entity User is a class that represent the User in this program.
 */

/**
 * push test
 */

public class User implements UserInterface{

    private final String name;
    private final String password;
    private final String ID;
    private final String Email;
    private final List<String> Courses;

    User(String name, String password, String ID, String Email,ArrayList<String> courses){
        this.name = name;
        this.password = password;
        this.ID = ID;
        this.Email = Email;
        this.Courses = courses; // Sign up use case will handle this and create user objects.
        // we can expect Ye Ziyi to pass in the ArrayList when cosntructing users
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public List<String> getCourses() {
        return Courses;
    }
}

