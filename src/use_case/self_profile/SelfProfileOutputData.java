package use_case.self_profile;

import entity.User;

public class SelfProfileOutputData {
	private final User currentUser;

	public SelfProfileOutputData(User user) {
		this.currentUser = user;
	}

	public User getCurrentUser() {
		return this.currentUser;
	}
}
