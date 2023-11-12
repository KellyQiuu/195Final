package interface_adapter.user_list;

import java.util.ArrayList;
import java.util.List;


public class UserListState {
    private ArrayList<String> userNames;


    public UserListState(){


    }

    public ArrayList<String> getUserNames(){
        System.out.println("user names are "+userNames.toString());
        return this.userNames;

    };

    public void setUserNames(ArrayList<String> names){
        this.userNames=names;
        System.out.println("User names set to: "+ userNames.toString());

    }
}
