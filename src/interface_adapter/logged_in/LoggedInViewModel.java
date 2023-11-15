package interface_adapter.logged_in;


import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// TODO: 11/14/2023 combined with mainviewmodel?
public class LoggedInViewModel extends ViewModel {
    private LoggedInState state = new LoggedInState();
    private String loggedInUser;

    public LoggedInViewModel() { super("Logged in"); }

    public void setState(LoggedInState state) { this.state = state; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoggedInState getState() {return state;}

    public String getLoggedInUser() {return loggedInUser;}

    public void setLoggedInUser(String loggedInUser) {this.loggedInUser = loggedInUser;}


}
