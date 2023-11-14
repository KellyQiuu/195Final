package interface_adapter.self_profile;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class SelfProfileViewModel extends ViewModel {
    public final String UPDATE_LABEL = "Update";
    public static final String UPDATE_BUTTON_LABEL = "Update";
    private SelfProfileState state = new SelfProfileState();

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
}
