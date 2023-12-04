
package use_case.user_list;


import data_access.PSQLDataAccessObject;
//import data_access.UserDataAccessObject;
import entity.User;
import entity.UserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UserListOutputData {
    private final ArrayList<User> sortedUsers;
    public UserListOutputData(ArrayList<User> sortedUsers){
        this.sortedUsers = sortedUsers;
    }
    //TODO: turn arrayList into a arraylist of hashmap, each hashmap is a user.

    public ArrayList<User> getUsers() throws IOException {
//        UserDataAccessObject dao = new UserDataAccessObject(new UserFactory());
        PSQLDataAccessObject dao = new PSQLDataAccessObject();

        return sortedUsers;
    }
}
