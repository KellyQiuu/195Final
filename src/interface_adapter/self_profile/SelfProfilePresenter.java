package interface_adapter.self_profile;

import entity.User;
import interface_adapter.ViewManagerModel;
import use_case.self_profile.SelfProfileOutputBoundary;
import use_case.self_profile.SelfProfileOutputData;

/**
 * Presenter class for the self profile, implementing the SelfProfileOutputBoundary interface.
 * This class is responsible for presenting the self profile data to the user interface, handling the view logic.
 */
public class SelfProfilePresenter implements SelfProfileOutputBoundary {
	private final SelfProfileViewModel profileViewModel;
	private ViewManagerModel viewManagerModel;

	/**
	 * Constructs a SelfProfilePresenter with the specified view model and view manager model.
	 *
	 * @param profileViewModel The view model for the self profile, holding state and logic for the view.
	 * @param viewManagerModel The model managing different views in the application.
	 */
	public SelfProfilePresenter(SelfProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
		this.profileViewModel = profileViewModel;
		this.viewManagerModel = viewManagerModel;
	}

	/**
	 * Prepares and updates the view for displaying the self profile data.
	 * This method is called when the self profile operation is successful and user data is available for display.
	 *
	 * @param userdata The output data containing the user's profile information.
	 */
	@Override
	public void prepareSuccessView(SelfProfileOutputData userdata) {
		User currentUser = userdata.getCurrentUser();
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
