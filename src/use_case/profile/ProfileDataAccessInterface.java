package use_case.profile;

import entity.User;
public interface ProfileDataAccessInterface {
	public User getUser(String username);
}
