package interface_adapter.self_profile;

import entity.User;
import interface_adapter.ViewManagerModel;
import use_case.self_profile.SelfProfileOutputBoundary;
import use_case.self_profile.SelfProfileOutputData;

import javax.swing.*;
import java.util.List;

public class SelfProfilePresenter implements SelfProfileOutputBoundary {
	private final SelfProfileViewModel profileViewModel;

	private ViewManagerModel viewManagerModel;

	public SelfProfilePresenter(SelfProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
		this.profileViewModel = profileViewModel;
		this.viewManagerModel = viewManagerModel;
	}

	@Override
	public void prepareSuccessView(SelfProfileOutputData userdata) {
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
