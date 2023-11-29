package use_case.signup;

import java.util.ArrayList;
import java.util.List;

/**
 * Application Business Rules layer .
 */
public class SignupInputData {
    final private String username;
    final private String password;
    final private String id;
    final private String email;
    final private List<String> courses;
    /**
     * @param username the username of the new user
     * @param password the password of the new user
     * @param id the id of the new user
     * @param email the email of the new user
     * @param courses the courses that the new user currently enrolled.
     */

    public SignupInputData(String username, String password, String id, String email,
                           ArrayList<String> courses) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.courses = courses;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getCourses() {
        return courses;
    }
}
