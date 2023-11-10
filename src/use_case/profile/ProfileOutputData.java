package use_case.profile;

import entity.User;

public class ProfileOutputData {
	private final User currentUser;

	public ProfileOutputData(User user) {
		this.currentUser = user;
	}

	public User getCurrentUser() {
		return this.currentUser;
	}
}
