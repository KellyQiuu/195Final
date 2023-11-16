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
		User otherUser = userdata.getOtherUser();
		if (otherUser == null) {
			JOptionPane.showMessageDialog(null, "This User is Null");
		} else {
			otherProfileViewModel.setUser(otherUser);
			otherProfileViewModel.firePropertyChanged();

			viewManagerModel.setActiveView(otherProfileViewModel.getViewName());
			viewManagerModel.firePropertyChanged();
		}
	}

}

