package interface_adapter.user_list;

import entity.User;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import use_case.user_list.UserListOutputData;
import use_case.user_list.UserListOutputBoundary;
import view.UserListViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import interface_adapter.ViewManagerModel;
public class UserListPresenter implements UserListOutputBoundary {


    private final OtherProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;
    private final UserListViewModel userListViewModel;

    public UserListPresenter(ViewManagerModel viewManagerModel,
                             OtherProfileViewModel profileViewModel,
                             UserListViewModel userListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.profileViewModel = profileViewModel;
        this.userListViewModel = userListViewModel;
    }

    @Override
    public void prepareSuccessView(UserListOutputData data) {
        // Directly use the list of User objects from the output data
        ArrayList<User> users = data.getUsers();
        UserListState state = userListViewModel.getState();
        // Update the state with the list of User objects
        state.setUsers(users);

        // Notify the view model of the state change
        userListViewModel.setState(state);
        System.out.println("(presenter) set state");
        userListViewModel.firePropertyChanged();

        // Optionally, if you need to switch views or perform additional view logic:
        // viewManagerModel.setActiveView(userListViewModel.getViewName());
        // viewManagerModel.firePropertyChanged();
        System.out.println("Prepare Success View method called in presenter");
    }

}
