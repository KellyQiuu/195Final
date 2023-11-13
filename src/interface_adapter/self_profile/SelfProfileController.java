package interface_adapter.self_profile;

import use_case.self_profile.SelfProfileInputBoundary;

public class SelfProfileController {
	final SelfProfileInputBoundary profileInteractor;

	public SelfProfileController(SelfProfileInputBoundary profileInteractor) {
		this.profileInteractor = profileInteractor;
	}
	public void execute(String username) {
		profileInteractor.execute(username);
	}
}
