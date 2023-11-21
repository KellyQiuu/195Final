package interface_adapter.self_profile;

import use_case.self_profile.SelfProfileInputBoundary;
import use_case.self_profile.SelfProfileInputData;

/**
 * Controller class for handling self profile operations in the interface layer.
 * This class acts as an intermediary between the user interface and the application logic related to self profiles.
 */
public class SelfProfileController {
	final SelfProfileInputBoundary profileInteractor;

	/**
	 * Constructs a SelfProfileController with the specified profile interactor.
	 *
	 * @param profileInteractor The input boundary for self profile use cases, responsible for processing self profile operations.
	 */
	public SelfProfileController(SelfProfileInputBoundary profileInteractor) {
		this.profileInteractor = profileInteractor;
	}

	/**
	 * Executes a self profile operation based on the provided username.
	 * This method initiates the process of handling self profile operations by creating input data and passing it to the interactor.
	 *
	 * @param username The username associated with the self profile operation.
	 */
	public void execute(String username) {
		SelfProfileInputData selfProfileInputData = new SelfProfileInputData(username);
		profileInteractor.execute(selfProfileInputData);
	}
}
