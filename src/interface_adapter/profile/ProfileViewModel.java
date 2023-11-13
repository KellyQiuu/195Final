package interface_adapter.profile;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ProfileViewModel extends ViewModel {
    public static final String CONNECT_BUTTON_LABEL = "Connect";
    public final String UPDATE_LABEL = "Update";
    public static final String UPDATE_BUTTON_LABEL = "Update";
    private ProfileState state = new ProfileState();

    public ProfileViewModel() {
        super("profile");
    }

    public void setState(ProfileState state) {
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

    public ProfileState getState() {
        return state;
    }
}
