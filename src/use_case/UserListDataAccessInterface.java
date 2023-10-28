package use_case;

import entity.User;

import java.util.ArrayList;

public interface UserListDataAccessInterface {
    public ArrayList<User> getAllUsers();
}
