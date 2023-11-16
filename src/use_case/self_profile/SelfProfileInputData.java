package use_case.self_profile;

public class SelfProfileInputData {
	final private String username;
	public SelfProfileInputData(String username) {
		this.username=username;

	}
	String getUsername() {
		return username;
	}
}
