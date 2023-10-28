package entity;

import java.util.List;

public class User implements UserInterface{

    private final String name;
    private final String password;
    private final String ID;
    private final String Email;
    private final List<String> Courses;

    User(String name, String password, String ID, String Email){
        this.name = name;
        this.password = password;
        this.ID = ID;
        this.Email = Email;
        this.Courses = null; // Set to null when register in default. Can modify later.
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
