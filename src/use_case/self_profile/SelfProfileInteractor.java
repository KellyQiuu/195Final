package use_case.self_profile;

import entity.User;

public class SelfProfileInteractor implements SelfProfileInputBoundary {

	final SelfProfileDataAccessInterface profileDataAccessObject;

	final SelfProfileOutputBoundary profilePresenter;

	public SelfProfileInteractor(SelfProfileDataAccessInterface profileDataAccessObject, SelfProfileOutputBoundary profilePresenter) {
		this.profilePresenter = profilePresenter;
		this.profileDataAccessObject = profileDataAccessObject;
	}


	@Override
	public void execute(SelfProfileInputData inputData) {
		User currentUser = profileDataAccessObject.getUser(inputData.getUsername());
		SelfProfileOutputData profileOutputData = new SelfProfileOutputData(currentUser);
		profilePresenter.prepareSuccessView(profileOutputData);
	}
}
