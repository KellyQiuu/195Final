package use_case.self_profile;

/**
 * Interface defining the input boundary for self profile use cases.
 * This boundary acts as a contract for implementing classes to process input data related to self profiles.
 */
public interface SelfProfileInputBoundary {
	/**
	 * Executes the necessary operations based on the provided self profile input data.
	 * This method is responsible for handling input data related to self profile operations.
	 *
	 * @param inputData The SelfProfileInputData containing data required for processing the self profile use case.
	 */
	void execute(SelfProfileInputData inputData);
}
