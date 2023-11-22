package use_case.user_list;

import entity.User;

import java.io.IOException;
import java.util.ArrayList;

public interface UserListDataAccessInterface {
    public ArrayList<User> getAllUsers();

    User get(String currentUserName) throws IOException;
}
