package interface_adapter.profile;

import entity.User;
import interface_adapter.ViewManagerModel;
import use_case.profile.ProfileOutputBoundary;
import use_case.profile.ProfileOutputData;
import view.ProfileView;

import javax.swing.*;
import java.util.List;

public class ProfilePresenter implements ProfileOutputBoundary {
	private final ProfileViewModel profileViewModel;

	private ViewManagerModel viewManagerModel;

	public ProfilePresenter(ProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
		this.profileViewModel = profileViewModel;
		this.viewManagerModel = viewManagerModel;
	}

	@Override
	public void prepareSuccessView(ProfileOutputData userdata) {
		profileViewModel.firePropertyChanged();
		viewManagerModel.firePropertyChanged();
		User currentUser = userdata.getCurrentUser();
		if (currentUser == null) {
			JOptionPane.showMessageDialog(null, "Current User is Null");
		} else {
			String name = currentUser.getName();
			String email = currentUser.getEmail();
			String password = currentUser.getPassword();
			List<String> courses = currentUser.getCourses();
		}
	}

}
