package interface_adapter.profile;

import interface_adapter.ViewManagerModel;
import use_case.profile.ProfileOutputBoundary;
import use_case.profile.ProfileOutputData;
import view.ProfileView;

public class ProfilePresenter implements ProfileOutputBoundary {
	private final ProfileViewModel profileViewModel;

	private ViewManagerModel viewManagerModel;

	public ProfilePresenter(ProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
		this.profileViewModel = profileViewModel;
		this.viewManagerModel = viewManagerModel;
	}

	@Override
	public void prepareSuccessView(ProfileOutputData userdata) {
		profileViewModel.firePropertyChanged();;
		viewManagerModel.firePropertyChanged();

	}

}
