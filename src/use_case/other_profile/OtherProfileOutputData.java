package use_case.other_profile;

import entity.User;

public class OtherProfileOutputData {
	private final User otherUser;

	public OtherProfileOutputData(User user) {
		this.otherUser = user;
	}

	public User getOtherUser() {
		return this.otherUser;
	}
}
