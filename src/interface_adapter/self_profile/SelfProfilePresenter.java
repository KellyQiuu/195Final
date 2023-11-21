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

		User currentUser = userdata.getCurrentUser();
		if (currentUser == null) {
			JOptionPane.showMessageDialog(null, "Current User is Null");
		} else {
			SelfProfileState selfProfileState = profileViewModel.getState();

			selfProfileState.setUserName(currentUser.getName());
			selfProfileState.setUserEmail(currentUser.getEmail());
			selfProfileState.setUserCourses(currentUser.getCourses());

			profileViewModel.setUser(currentUser);
			profileViewModel.firePropertyChanged();
			
			viewManagerModel.setActiveView(profileViewModel.getViewName());
			viewManagerModel.firePropertyChanged();
		}

	}

}
