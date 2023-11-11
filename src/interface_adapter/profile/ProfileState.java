package interface_adapter.profile;

public class ProfileState {
	private boolean modified = false;
	public ProfileState(ProfileState copy) {
		this.modified = copy.modified;
	}
	public ProfileState() {

	}
	public boolean getState() {
		return this.modified;
	}
	public void setState(boolean bool) {
		this.modified = bool;
	}
}
