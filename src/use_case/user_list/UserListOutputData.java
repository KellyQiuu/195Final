
package use_case.user_list;


import entity.GeneralUser;
import entity.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserListOutputData {
    private final ArrayList<GeneralUser> sortedUsers;
    public UserListOutputData(ArrayList<GeneralUser> sortedUsers){
        this.sortedUsers = sortedUsers;
    }
    //TODO: turn arrayList into a arraylist of hashmap, each hashmap is a user.

    public ArrayList<GeneralUser> getUsers() {
        return this.sortedUsers;
    }
}
