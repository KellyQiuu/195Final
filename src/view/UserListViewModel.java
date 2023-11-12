package view;


import java.beans.PropertyChangeListener;
import interface_adapter.user_list.UserListState;

import java.beans.PropertyChangeSupport;
public class UserListViewModel extends ViewModel {
    public final String TITLE_LABEL = "User List View";
    private UserListState state;
    public UserListViewModel(UserListState listViewState) {
        super("User List");
        this.state = listViewState;
    }

    public void setState(UserListState state){

        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
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
