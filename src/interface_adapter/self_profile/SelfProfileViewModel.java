package interface_adapter.self_profile;

import entity.User;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class SelfProfileViewModel extends ViewModel {
    private SelfProfileState state = new SelfProfileState();
    private User user;

    public SelfProfileViewModel() {
        super("profile");
    }

    public void setState(SelfProfileState state) {
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

    public SelfProfileState getState() {
        return state;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
