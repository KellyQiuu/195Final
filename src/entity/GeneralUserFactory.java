package entity;

import java.util.ArrayList;

public abstract class GeneralUserFactory {
    public static GeneralUser createUser(String username,
                                  String password, String id,
                                  String email,
                                  ArrayList<String> courses) {
        User user = new User(username, password, id, email, courses);
        System.out.println("(User factory) created: user "+ user.getName()+" with courses :"+user.getCourses());
        return user;
    }
}
