package use_case.user_list;

import entity.GeneralUser;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;

public interface UserListDataAccessInterface {
    public ArrayList<GeneralUser> getAllUsers();

    GeneralUser get(String currentUserName) throws IOException;
}
