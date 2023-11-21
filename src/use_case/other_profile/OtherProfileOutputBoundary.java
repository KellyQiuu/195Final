package use_case.other_profile;

import use_case.other_profile.OtherProfileOutputData;

/**
 * Interface defining the output boundary for other profile use cases.
 * This boundary provides a contract for implementing classes to present the results of operations concerning other users' profiles.
 */
public interface OtherProfileOutputBoundary {

	/**
	 * Prepares and presents the view for a successful operation related to other users' profiles.
	 * This method is responsible for handling the presentation logic of the user data processed by the use case.
	 *
	 * @param userdata The OtherProfileOutputData containing the user data to be presented.
	 */
	void prepareSuccessView(OtherProfileOutputData userdata);
}
