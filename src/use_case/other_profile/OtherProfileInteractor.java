package use_case.other_profile;

import entity.User;

public class OtherProfileInteractor implements OtherProfileInputBoundary{
	final OtherProfileDataAccessInterface profileDataAccessObject;

	final OtherProfileOutputBoundary profilePresenter;

	public OtherProfileInteractor(OtherProfileDataAccessInterface profileDataAccessObject, OtherProfileOutputBoundary profilePresenter) {
		this.profilePresenter = profilePresenter;
		this.profileDataAccessObject = profileDataAccessObject;
	}


	@Override
	public void execute(OtherProfileInputData otherProfileInputData) {
		System.out.println("Current User name:" + otherProfileInputData.getUsername());
		User currentUser = profileDataAccessObject.getUser(otherProfileInputData.getUsername());
		OtherProfileOutputData profileOutputData = new OtherProfileOutputData(currentUser);
		profilePresenter.prepareSuccessView(profileOutputData);
	}

}
