package interface_adapter.user_list;

import entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserListState {
    private ArrayList<User> users;


    public UserListState() {
        this.users = new ArrayList<>(); // Initialize the list
    }

    public ArrayList<User> getUsers() {

        return this.users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        System.out.println("Users set. Total: " + users.size());
    }
}
