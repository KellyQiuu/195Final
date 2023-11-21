package interface_adapter.other_profile;

import use_case.other_profile.OtherProfileInputBoundary;
import use_case.other_profile.OtherProfileInputData;

/**
 * Controller class for handling operations related to other users' profiles in the interface layer.
 * This class acts as an intermediary between the user interface and the application logic concerning other profiles.
 */
public class OtherProfileController {
	final OtherProfileInputBoundary otherProfileInteractor;

	/**
	 * Constructs an OtherProfileController with the specified profile interactor.
	 *
	 * @param otherProfileInteractor The input boundary for other profile use cases, responsible for processing other profile operations.
	 */
	public OtherProfileController(OtherProfileInputBoundary otherProfileInteractor) {
		this.otherProfileInteractor = otherProfileInteractor;
	}

	/**
	 * Executes an operation related to another user's profile based on the provided username.
	 * This method initiates the process of handling other profile operations by creating input data and passing it to the interactor.
	 *
	 * @param username The username associated with the other user's profile operation.
	 */
	public void execute(String username) {
		OtherProfileInputData otherProfileInputData = new OtherProfileInputData(username);
		System.out.println("otherProfileInputData: " + username);
		otherProfileInteractor.execute(otherProfileInputData);
	}
}
