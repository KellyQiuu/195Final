package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class SignupViewModel extends ViewModel{

    public static final String USERNAME_LABEL = "Username";

    public static final String PASSWORD_LABEL = "Password";

    public static final String EMAIL_LABEL = "Email";

    public static final String COURSE1 = "Course1";

    public static final String COURSE2 = "Course2";

    public static final String COURSE3 = "Course3";

    public static final String COURSE4 = "Course4";

    public static final String COURSE5 = "Course5";

    public static final String SIGNUP_LABEL = "Sign up";

    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private SignupState state = new SignupState();
    public SignupViewModel() {
        super("sign up");
    }

    public void setState(SignupState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SignupState getState() {
        return state;
    }
}