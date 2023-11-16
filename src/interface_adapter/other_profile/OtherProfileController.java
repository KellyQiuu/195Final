package interface_adapter.other_profile;

import use_case.other_profile.OtherProfileInputBoundary;
import use_case.other_profile.OtherProfileInputData;

public class OtherProfileController {
	final OtherProfileInputBoundary otherProfileInteractor;

	public OtherProfileController(OtherProfileInputBoundary otherProfileInteractor) {
		this.otherProfileInteractor = otherProfileInteractor;
	}
	public void execute(OtherProfileInputData otherProfileInputData) {
		otherProfileInteractor.execute(otherProfileInputData);
	}
}
