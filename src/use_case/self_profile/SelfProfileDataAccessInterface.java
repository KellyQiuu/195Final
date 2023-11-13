package use_case.self_profile;

import entity.User;
public interface SelfProfileDataAccessInterface {
	public User getUser(String username);
}
