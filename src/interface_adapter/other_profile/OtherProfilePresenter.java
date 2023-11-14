package interface_adapter.other_profile;

import entity.User;
import interface_adapter.ViewManagerModel;
import use_case.other_profile.OtherProfileOutputBoundary;
import use_case.other_profile.OtherProfileOutputData;

import javax.swing.*;
import java.util.List;

public class OtherProfilePresenter implements OtherProfileOutputBoundary {
	private final OtherProfileViewModel otherProfileViewModel;

	private ViewManagerModel viewManagerModel;

	public OtherProfilePresenter(OtherProfileViewModel otherProfileViewModel, ViewManagerModel viewManagerModel) {
		this.otherProfileViewModel = otherProfileViewModel;
		this.viewManagerModel = viewManagerModel;
	}

	@Override
	public void prepareSuccessView(OtherProfileOutputData userdata) {
		otherProfileViewModel.firePropertyChanged();
		viewManagerModel.firePropertyChanged();
		User currentUser = userdata.getCurrentUser();
		if (currentUser == null) {
			JOptionPane.showMessageDialog(null, "Other User is Null");
		} else {
			String name = currentUser.getName();
			String email = currentUser.getEmail();
			String password = currentUser.getPassword();
			List<String> courses = currentUser.getCourses();
		}
	}

}

