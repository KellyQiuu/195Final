package interface_adapter.other_profile;

import java.util.ArrayList;
import java.util.List;

public class OtherProfileState {

	private String userName;
	private String userEmail;
	private List<String> userCourses;
	public OtherProfileState(OtherProfileState copy) {
		this.userName = copy.userName;
		this.userEmail = copy.userEmail;
		this.userCourses = copy.userCourses;
	}
	public OtherProfileState() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<String> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(List<String> userCourses) {
		this.userCourses = userCourses;
	}
}
