
package use_case.user_list;


import entity.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserListOutputData {
    private final ArrayList<User> sortedUsers;
    public UserListOutputData(ArrayList<User> sortedUsers){
        this.sortedUsers = sortedUsers;
    }
    //TODO: turn arrayList into a arraylist of hashmap, each hashmap is a user.

    public ArrayList<User> getUsers() {
        return this.sortedUsers;
    }
}
