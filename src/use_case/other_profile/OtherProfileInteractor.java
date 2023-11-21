package use_case.other_profile;

import entity.User;

/**
 * Interactor class implementing the OtherProfileInputBoundary interface.
 * This class is responsible for handling the business logic of the other profile use case.
 */
public class OtherProfileInteractor implements OtherProfileInputBoundary {
	final private OtherProfileDataAccessInterface profileDataAccessObject;
	final private OtherProfileOutputBoundary profilePresenter;

	/**
	 * Constructs an OtherProfileInteractor with specified data access and output boundary objects.
	 *
	 * @param profileDataAccessObject The data access interface to interact with other users' profile data.
	 * @param profilePresenter        The output boundary interface to present the results of the other profile operation.
	 */
	public OtherProfileInteractor(OtherProfileDataAccessInterface profileDataAccessObject, OtherProfileOutputBoundary profilePresenter) {
		this.profileDataAccessObject = profileDataAccessObject;
		this.profilePresenter = profilePresenter;
	}

	/**
	 * Executes the other profile operation.
	 * Retrieves user data based on the input data and instructs the presenter to prepare the view.
	 *
	 * @param otherProfileInputData The input data containing necessary information like username for the operation.
	 */
	@Override
	public void execute(OtherProfileInputData otherProfileInputData) {
		System.out.println("Current User name:" + otherProfileInputData.getUsername());
		User currentUser = profileDataAccessObject.getUser(otherProfileInputData.getUsername());
		OtherProfileOutputData profileOutputData = new OtherProfileOutputData(currentUser);
		profilePresenter.prepareSuccessView(profileOutputData);
	}
}
