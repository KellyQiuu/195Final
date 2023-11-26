package interface_adapter.other_profile;

import entity.User;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the other user's profile in the application.
 * This class is responsible for storing and managing the state and data of another user's profile.
 */
public class OtherProfileViewModel extends ViewModel {
	public static final String CONNECT_BUTTON_LABEL = "Connect";
	public static final String TITLE_LABEL = "User Profile";
	public static final String USERNAME_LABEL = "Username";

	private OtherProfileState state = new OtherProfileState();
	private User user;

	/**
	 * Constructs an OtherProfileViewModel.
	 */
	public OtherProfileViewModel() {
		super("other_profile");
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
	 * Retrieves the current state of the other user's profile.
	 *
	 * @return The current OtherProfileState.
	 */
	public OtherProfileState getState() {
		return state;
	}

	/**
	 * Retrieves the current User entity.
	 *
	 * @return The current User.
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the current User entity and updates the state.
	 *
	 * @param user The User entity to set.
	 */
	public void setUser(User user) {
		this.user = user;
		this.state.setUserName(user.getName());
		this.state.setUserEmail(user.getEmail());
		this.state.setUserCourses(user.getCourses());
	}
}
