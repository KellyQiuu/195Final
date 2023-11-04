package view;
import view.ViewModel;


import java.beans.PropertyChangeListener;
import interface_adapter.UserListState;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class UserListViewModel extends ViewModel {
    public final String TITLE_LABEL = "User List View";
    private UserListState state;
    public UserListViewModel() {
        super("User List");
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
