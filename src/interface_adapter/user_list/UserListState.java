package interface_adapter.user_list;

import java.util.ArrayList;
import java.util.List;


public class UserListState {
    private ArrayList<String> userNames;


    public UserListState(){


    }

    public ArrayList<String> getUserNames(){
        return this.userNames;
    };

    public void setUserNames(ArrayList<String> names){
        this.userNames=names;
    }
}
