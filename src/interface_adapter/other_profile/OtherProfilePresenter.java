package interface_adapter.other_profile;

import entity.GeneralUser;
import entity.User;
import interface_adapter.ViewManagerModel;
import use_case.other_profile.OtherProfileOutputBoundary;
import use_case.other_profile.OtherProfileOutputData;

/**
 * Presenter class for the other user's profile, implementing the OtherProfileOutputBoundary interface.
 * This class is responsible for presenting the data of other users' profiles to the user interface, handling the view logic.
 */
public class OtherProfilePresenter implements OtherProfileOutputBoundary {

	private final OtherProfileViewModel otherProfileViewModel;
	private ViewManagerModel viewManagerModel;

	/**
	 * Constructs an OtherProfilePresenter with the specified view model and view manager model.
	 *
	 * @param otherProfileViewModel The view model for other profiles, holding state and logic for the view.
	 * @param viewManagerModel      The model managing different views in the application.
	 */
	public OtherProfilePresenter(OtherProfileViewModel otherProfileViewModel, ViewManagerModel viewManagerModel) {
		this.otherProfileViewModel = otherProfileViewModel;
		this.viewManagerModel = viewManagerModel;
	}

	/**
	 * Prepares and updates the view for displaying other users' profile data.
	 * This method is called when the other profile operation is successful and user data is available for display.
	 *
	 * @param userdata The output data containing the other user's profile information.
	 */
	@Override
	public void prepareSuccessView(OtherProfileOutputData userdata) {
		GeneralUser otherUser = userdata.getOtherUser();
		OtherProfileState otherProfileState = otherProfileViewModel.getState();
		otherProfileState.setUserName(otherUser.getName());
		otherProfileState.setUserEmail(otherUser.getEmail());
		otherProfileState.setUserCourses(otherUser.getCourses());

		otherProfileViewModel.setUser(otherUser);

		otherProfileViewModel.firePropertyChanged();
		viewManagerModel.setActiveView(otherProfileViewModel.getViewName());
		viewManagerModel.firePropertyChanged();
	}
}
