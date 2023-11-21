package interface_adapter.other_profile;

import java.util.List;

/**
 * Class representing the state of another user's profile in the application.
 * This class holds the profile information of another user, such as name, email, and courses.
 */
public class OtherProfileState {

	private String userName;
	private String userEmail;
	private List<String> userCourses;

	/**
	 * Constructs a copy of an existing OtherProfileState.
	 *
	 * @param copy The OtherProfileState instance to be copied.
	 */
	public OtherProfileState(OtherProfileState copy) {
		this.userName = copy.userName;
		this.userEmail = copy.userEmail;
		this.userCourses = copy.userCourses;
	}
	/**
	 * Default constructor for OtherProfileState.
	 */
	public OtherProfileState() {
	}

	/**
	 * Retrieves the other user's name.
	 *
	 * @return The other user's name.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the other user's name.
	 *
	 * @param userName The name to set for the other user.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Retrieves the other user's email.
	 *
	 * @return The other user's email.
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * Sets the other user's email.
	 *
	 * @param userEmail The email to set for the other user.
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Retrieves the list of courses associated with the other user.
	 *
	 * @return A list of courses.
	 */
	public List<String> getUserCourses() {
		return userCourses;
	}

	/**
	 * Sets the list of courses for the other user.
	 *
	 * @param userCourses The list of courses to be associated with the other user.
	 */
	public void setUserCourses(List<String> userCourses) {
		this.userCourses = userCourses;
	}
}
