package entity;
import java.util.List;

import java.util.ArrayList;

/**
 * This entity User is a class that represent the User in this program.
 */


public class User implements UserInterface{

    private final String name;
    private final String password;
    private final String id;
    private final String email;
    private final List<String> courses;

    User(String name, String password, String id, String Email, ArrayList<String> courses){
        this.name = name;
        this.password = password;
        this.id = id;
        this.email = Email;
        this.courses = courses; // Sign up use case will handle this and create user objects.
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
    public String getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public List<String> getCourses() {
        return courses;
    }


}

