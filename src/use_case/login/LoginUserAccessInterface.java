package use_case.login;

import entity.User;

import java.io.IOException;

/**
 * Application Business Rules layer interface for accessing user data.
 */

public interface LoginUserAccessInterface {
    /**
     * @param username string username of the User to check if it has been taken.
     * @return true if and only if the username has not been taken and the user can register with this name.
     */
    boolean existsByName(String username);

    /**
     * Saves a new user to the database.
     * @param user newly created User object
     */
    void save(User user);

    User get(String username) throws IOException;

    String getPass(String username);

    User get2(String username) throws IOException;
}
