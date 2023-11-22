package view;


import java.beans.PropertyChangeListener;
import interface_adapter.user_list.UserListState;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserListViewModel extends ViewModel {
    public final String TITLE_LABEL = "User List View";
    private UserListState state = new UserListState();
    public UserListViewModel() {
        super("User List");

    }

    public void setState(UserListState state){

        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    // Method to get user data in a format suitable for the view
    public ArrayList<String> getUserDisplayData() {

        return state.getUsers().stream()
                .map(user ->user.getName() + "\n"+"Courses: "+"\n" + user.getCourses())
                .collect(Collectors.toCollection(ArrayList::new));
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public UserListState getState(){
        return this.state;
    }


}
