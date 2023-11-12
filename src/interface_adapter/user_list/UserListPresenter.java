package interface_adapter.user_list;

import entity.User;
import use_case.user_list.UserListOutputData;
import use_case.user_list.UserListOutputBoundary;
import view.UserListViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import interface_adapter.ViewManagerModel;

public class UserListPresenter implements UserListOutputBoundary {

    private final UserListState viewState;
    private final ViewManagerModel viewManagerModel;
    private final UserListViewModel userListViewModel;

    public UserListPresenter(ViewManagerModel viewManagerModel,
                             UserListState viewState,
                             UserListViewModel userListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.viewState = viewState;
        this.userListViewModel = userListViewModel;
    }

    @Override
    public void prepareSuccessView(UserListOutputData data) {
        // Extract the list of usernames from the output data
        List<String> userNames = data.getUsers().stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());

        // Update the state
        viewState.setUserNames((ArrayList<String>) userNames);

        // Notify the view model of the state change
        userListViewModel.setState(viewState);
        userListViewModel.firePropertyChanged();

        // Optionally, if you need to switch views or perform additional view logic:
        // viewManagerModel.setActiveView(userListViewModel.getViewName());
        // viewManagerModel.firePropertyChanged();
        System.out.println("Prepare Succees View method called in presenter");
    }


}
