package interface_adapter.self_profile;

import entity.GeneralUser;
import entity.User;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the self profile view in the application.
 * This class is responsible for storing and managing the state and data of the user's profile.
 */
public class SelfProfileViewModel extends ViewModel {
    private SelfProfileState state = new SelfProfileState();
    private GeneralUser user;
    public static final String TITLE_LABEL = "My Profile";

    /**
     * Constructs a SelfProfileViewModel.
     */
    public SelfProfileViewModel() {
        super("self_profile");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify observers of a change in the state.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state.getUserName());
    }

    /**
     * Adds a PropertyChangeListener to the listener list.
     *
     * @param listener The PropertyChangeListener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of the self profile.
     *
     * @return The current SelfProfileState.
     */
    public SelfProfileState getState() {
        return state;
    }

    /**
     * Retrieves the current User entity.
     *
     * @return The current User.
     */
    public GeneralUser getUser() {
        return this.user;
    }

    /**
     * Sets the current User entity and updates the state.
     *
     * @param user The User entity to set.
     */
    public void setUser(GeneralUser user) {
        this.user = user;
        this.state.setUserName(user.getName());
        this.state.setUserEmail(user.getEmail());
        this.state.setUserCourses(user.getCourses());
    }
}
