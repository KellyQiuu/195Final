package use_case.profile;

import entity.User;

public class ProfileInteractor implements ProfileInputBoundary{

	final ProfileDataAccessInterface profileDataAccessObject;

	final ProfileOutputBoundary profilePresenter;

	public ProfileInteractor(ProfileDataAccessInterface profileDataAccessObject, ProfileOutputBoundary profilePresenter) {
		this.profilePresenter = profilePresenter;
		this.profileDataAccessObject = profileDataAccessObject;
	}


	@Override
	public void execute(String username) {
		User currentUser = profileDataAccessObject.getUser(username);
		ProfileOutputData profileOutputData = new ProfileOutputData(currentUser);
		profilePresenter.prepareSuccessView(profileOutputData);
	}
}
