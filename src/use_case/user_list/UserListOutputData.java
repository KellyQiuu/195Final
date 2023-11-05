
package use_case.user_list;


import entity.User;

import java.util.ArrayList;

public class UserListOutputData {
    private final ArrayList<User> sortedUsers;
    public UserListOutputData(ArrayList<User> sortedUsers){
        this.sortedUsers = sortedUsers;
    }
    public ArrayList<User> getSortedUsers(){
        return sortedUsers;
    }
}
