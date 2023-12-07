package interface_adapter.user_list;



import entity.GeneralUser;

import java.util.ArrayList;


public class UserListState {
    private ArrayList<GeneralUser> users;

    private String currentusername;


    public UserListState() {
        this.users = new ArrayList<>(); // Initialize the list
    }

    public ArrayList<GeneralUser> getUsers() {

        return this.users;
    }

    public void setUsers(ArrayList<GeneralUser> users) {
        this.users = users;
        System.out.println("Users set. Total: " + users.size());
    }

    public void setUsername(String username) {
        this.currentusername = username;
    }

}
