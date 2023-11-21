package use_case.self_profile;

/**
 * Interface defining the output boundary for self profile use cases.
 * This boundary provides a contract for implementing classes to present the results of self profile operations.
 */
public interface SelfProfileOutputBoundary {
	/**
	 * Prepares and presents the view for a successful self profile operation.
	 * This method is responsible for handling the presentation logic of the user data processed by the use case.
	 *
	 * @param userdata The SelfProfileOutputData containing the user data to be presented.
	 */
	void prepareSuccessView(SelfProfileOutputData userdata);
}
