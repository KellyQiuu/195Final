package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This entity is the implementation that create Users for the program.
 */

public class UserFactory {
    public static User creatUser(String username,
                          String password,
                          String email,
                          ArrayList<String> courses){
        return new User(username, password, null, email, courses);
    }
}

