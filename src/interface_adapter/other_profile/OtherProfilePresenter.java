package interface_adapter.other_profile;

import entity.User;
import interface_adapter.ViewManagerModel;
import use_case.other_profile.OtherProfileOutputBoundary;
import use_case.other_profile.OtherProfileOutputData;

import javax.swing.*;

public class OtherProfilePresenter implements OtherProfileOutputBoundary {

	private final OtherProfileViewModel otherProfileViewModel;

	private ViewManagerModel viewManagerModel;

	public OtherProfilePresenter(OtherProfileViewModel otherProfileViewModel, ViewManagerModel viewManagerModel) {
		this.otherProfileViewModel = otherProfileViewModel;
		this.viewManagerModel = viewManagerModel;
	}

	@Override
	public void prepareSuccessView(OtherProfileOutputData userdata) {
		User otherUser = userdata.getOtherUser();
		OtherProfileState otherProfileState = otherProfileViewModel.getState();
		otherProfileState.setUserName(otherUser.getName());
		otherProfileState.setUserEmail(otherUser.getEmail());
		otherProfileState.setUserCourses(otherUser.getCourses());
		System.out.println("PrepareSuccessView");
		otherProfileViewModel.setUser(otherUser);

		System.out.println("ProfileViewModel knows: " + otherProfileViewModel.getUser().getName());
		otherProfileViewModel.firePropertyChanged();

		viewManagerModel.setActiveView(otherProfileViewModel.getViewName());
		viewManagerModel.firePropertyChanged();
	}

}

