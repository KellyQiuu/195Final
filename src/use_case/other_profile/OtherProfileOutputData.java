package use_case.other_profile;

import entity.User;

public class OtherProfileOutputData {
	private final User currentUser;

	public OtherProfileOutputData(User user) {
		this.currentUser = user;
	}

	public User getCurrentUser() {
		return this.currentUser;
	}
}
