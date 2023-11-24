package use_case.other_profile;

/**
 * Encapsulates the input data for other profile use cases.
 * This class holds the necessary information required for processing operations related to other users' profiles.
 */
public class OtherProfileInputData {
	final private String username;

	/**
	 * Constructs an OtherProfileInputData instance with the specified username.
	 *
	 * @param username The username associated with the other user's profile operation.
	 */
	public OtherProfileInputData(String username) {
		this.username = username;
	}

	/**
	 * Retrieves the username associated with this input data.
	 *
	 * @return The username.
	 */
	public String getUsername() {
		return username;
	}
}
