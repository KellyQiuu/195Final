package use_case.other_profile;

/**
 * Interface defining the input boundary for other profile use cases.
 * This boundary acts as a contract for implementing classes to process input data related to other users' profiles.
 */
public interface OtherProfileInputBoundary {

	/**
	 * Executes the necessary operations based on the provided other profile input data.
	 * This method is responsible for handling input data related to operations concerning other users' profiles.
	 *
	 * @param otherProfileInputData The OtherProfileInputData containing data required for processing the other user's profile use case.
	 */
	void execute(OtherProfileInputData otherProfileInputData);
}
