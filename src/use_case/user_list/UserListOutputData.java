
package use_case.user_list;



import entity.GeneralUser;

import data_access.PSQLDataAccessObject;

import entity.User;
import entity.UserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UserListOutputData {
    private final ArrayList<GeneralUser> sortedUsers;
    public UserListOutputData(ArrayList<GeneralUser> sortedUsers){
        this.sortedUsers = sortedUsers;
    }
    //TODO: turn arrayList into a arraylist of hashmap, each hashmap is a user.

    public ArrayList<GeneralUser> getUsers() throws IOException {
//        UserDataAccessObject dao = new UserDataAccessObject(new UserFactory());
        PSQLDataAccessObject dao = new PSQLDataAccessObject();

        return sortedUsers;

    }
}
