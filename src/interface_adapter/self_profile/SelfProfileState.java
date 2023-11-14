package interface_adapter.self_profile;

public class SelfProfileState {
	private boolean modified = false;
	public SelfProfileState(SelfProfileState copy) {
		this.modified = copy.modified;
	}
	public SelfProfileState() {

	}
	public boolean getState() {
		return this.modified;
	}
	public void setState(boolean bool) {
		this.modified = bool;
	}
}
