package interface_adapter.other_profile;

public class OtherProfileState {
	private boolean modified = false;
	public OtherProfileState(OtherProfileState copy) {
		this.modified = copy.modified;
	}
	public OtherProfileState() {

	}
	public boolean getState() {
		return this.modified;
	}
	public void setState(boolean bool) {
		this.modified = bool;
	}
}
