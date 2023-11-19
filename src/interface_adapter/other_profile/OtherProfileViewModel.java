package interface_adapter.other_profile;

import entity.User;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class OtherProfileViewModel extends ViewModel {
	public static final String CONNECT_BUTTON_LABEL = "Connect";
	public static final String TITLE_LABEL = "Profile";
	public static final String USERNAME_LABEL = "Username";
	private OtherProfileState state = new OtherProfileState();
	private User user;

	public OtherProfileViewModel() {
		super("other_profile");
	}

	public void setState(OtherProfileState state) {
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

	public OtherProfileState getState() {
		return state;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

