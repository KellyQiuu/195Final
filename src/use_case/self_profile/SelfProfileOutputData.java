package use_case.self_profile;

import entity.User;

/**
 * Class that encapsulates the output data for self profile use cases.
 * This class holds the data necessary for presenting the user profile information.
 */
public class SelfProfileOutputData {
	private final User currentUser;

	/**
	 * Constructs a SelfProfileOutputData instance with the specified user.
	 *
	 * @param user The user whose profile data is to be encapsulated.
	 */
	public SelfProfileOutputData(User user) {
		this.currentUser = user;
	}

	/**
	 * Retrieves the current user associated with this output data.
	 *
	 * @return The current User instance.
	 */
	public User getCurrentUser() {
		return this.currentUser;
	}
}
