package interface_adapter.profile;

import use_case.profile.ProfileInputBoundary;
public class ProfileController {
	final ProfileInputBoundary profileInteractor;

	public ProfileController(ProfileInputBoundary profileInteractor) {
		this.profileInteractor=profileInteractor;
	}

	public void execute(String username) {
		profileInteractor.execute(username);
	}
}
