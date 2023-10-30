package entity;

import java.util.List;

public interface UserInterface {
    // added this interface to allow later adding different types of users.
    // adhere to Open Clsoed Principle.
    String getName();

    String getPassword();

    String getID();

    String getEmail();

    List<String> getCourses();

}
