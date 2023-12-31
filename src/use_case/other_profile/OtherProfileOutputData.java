package use_case.other_profile;

import entity.GeneralUser;
import entity.User;

/**
 * Class that encapsulates the output data for other profile use cases.
 * This class holds the data necessary for presenting other users' profile information.
 */
public class OtherProfileOutputData {
	private final GeneralUser otherUser;

	/**
	 * Constructs an OtherProfileOutputData instance with the specified user.
	 *
	 * @param user The user whose profile data is to be encapsulated. This is typically the profile of another user.
	 */
	public OtherProfileOutputData(GeneralUser user) {
		this.otherUser = user;
	}

	/**
	 * Retrieves the other user associated with this output data.
	 *
	 * @return The other User instance.
	 */
	public GeneralUser getOtherUser() {
		return this.otherUser;
	}
}
