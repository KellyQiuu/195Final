package interface_adapter.self_profile;

import java.util.List;

/**
 * Class representing the state of a self profile in the application.
 * This class holds the user's profile information, such as name, email, and courses.
 */
public class SelfProfileState {

	private String userName;
	private String userEmail;
	private List<String> userCourses;

	/**
	 * Constructs a copy of an existing SelfProfileState.
	 *
	 * @param copy The SelfProfileState instance to be copied.
	 */
	public SelfProfileState(SelfProfileState copy) {
		this.userName = copy.userName;
		this.userEmail = copy.userEmail;
		this.userCourses = copy.userCourses; // Note: Consider deep copying if necessary.
	}

	/**
	 * Default constructor for SelfProfileState.
	 */
	public SelfProfileState() {
		// Initialize with default values or leave it for later initialization
	}

	/**
	 * Retrieves the user's name.
	 *
	 * @return The user's name.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user's name.
	 *
	 * @param userName The name to set for the user.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Retrieves the user's email.
	 *
	 * @return The user's email.
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * Sets the user's email.
	 *
	 * @param userEmail The email to set for the user.
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Retrieves the list of courses associated with the user.
	 *
	 * @return A list of courses.
	 */
	public List<String> getUserCourses() {
		return userCourses;
	}

	/**
	 * Sets the list of courses for the user.
	 *
	 * @param userCourses The list of courses to be associated with the user.
	 */
	public void setUserCourses(List<String> userCourses) {
		this.userCourses = userCourses;
	}
}
