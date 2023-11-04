package interface_adapter;

import javax.lang.model.element.Name;
import java.util.ArrayList;

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
