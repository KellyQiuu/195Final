package use_case.user_list;

import entity.User;

import java.util.ArrayList;

public interface UserListDataAccessInterface {
    public ArrayList<User> getAllUsers();
}
