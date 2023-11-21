package use_case.self_profile;

import entity.User;

/**
 * Interactor class implementing the SelfProfileInputBoundary interface.
 * This class is responsible for handling the self profile use case logic.
 */
public class SelfProfileInteractor implements SelfProfileInputBoundary {

	final SelfProfileDataAccessInterface profileDataAccessObject;
	final SelfProfileOutputBoundary profilePresenter;

	/**
	 * Constructs a SelfProfileInteractor with specified data access and output boundary objects.
	 *
	 * @param profileDataAccessObject The data access interface to interact with user profile data.
	 * @param profilePresenter        The output boundary interface to present the results of the self profile operation.
	 */
	public SelfProfileInteractor(SelfProfileDataAccessInterface profileDataAccessObject, SelfProfileOutputBoundary profilePresenter) {
		this.profilePresenter = profilePresenter;
		this.profileDataAccessObject = profileDataAccessObject;
	}

	/**
	 * Executes the self profile operation.
	 * Retrieves user data based on the input data and instructs the presenter to prepare the view.
	 *
	 * @param inputData The input data containing necessary information like username for the operation.
	 */
	@Override
	public void execute(SelfProfileInputData inputData) {
		User currentUser = profileDataAccessObject.getUser(inputData.getUsername());
		SelfProfileOutputData profileOutputData = new SelfProfileOutputData(currentUser);
		profilePresenter.prepareSuccessView(profileOutputData);
	}
}
