package use_case.other_profile;

import entity.User;
import entity.UserFactory;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.self_profile.SelfProfileOutputBoundary;
import use_case.self_profile.SelfProfileOutputData;

public class OtherProfileInteractor implements OtherProfileInputBoundary{
	final OtherProfileDataAccessInterface profileDataAccessObject;

	final OtherProfileOutputBoundary profilePresenter;

	public OtherProfileInteractor(OtherProfileDataAccessInterface profileDataAccessObject, OtherProfileOutputBoundary profilePresenter) {
		this.profilePresenter = profilePresenter;
		this.profileDataAccessObject = profileDataAccessObject;
	}


	@Override
	public void execute(OtherProfileInputData otherProfileInputData) {
		User currentUser = profileDataAccessObject.getUser(otherProfileInputData.getUsername());
		OtherProfileOutputData profileOutputData = new OtherProfileOutputData(currentUser);
		profilePresenter.prepareSuccessView(profileOutputData);
	}

	private User censorUserData(User user) {
		// Need to censor the user data : Password and ID.
		return null;
	}
}
