package use_case.other_profile;

import entity.User;

/**
 * Interface for accessing other users' profile data.
 * Defines the contract for implementations that provide access to the profile information of other users.
 */
public interface OtherProfileDataAccessInterface {

	/**
	 * Retrieves the User entity based on the provided username.
	 * This method is intended for accessing the profile data of other users in the system.
	 *
	 * @param username The username of the other user whose profile data is to be retrieved.
	 * @return User The User entity associated with the given username. Returns null if the user is not found.
	 */
	public User getUser(String username);
}
