package entity;

import java.util.List;

public interface GeneralUser {
    // added this interface to allow later adding different types of users.
    // adhere to Open Clsoed Principle.
    String getName();

    String getPassword();

    String getId();

    String getEmail();

    List<String> getCourses();

    String getCoursesString();
}
