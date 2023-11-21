package use_case.self_profile;

import entity.User;
/**
 * Interface for accessing self profile data.
 * Defines the contract for implementations that provide access to user profile information.
 */
public interface SelfProfileDataAccessInterface {
	/**
	 * Retrieves the User entity based on the provided username.
	 *
	 * @param username The username of the user whose profile data is to be retrieved.
	 * @return User The User entity associated with the given username. Returns null if the user is not found.
	 */
	public User getUser(String username);
}
