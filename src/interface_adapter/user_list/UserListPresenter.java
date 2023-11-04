package interface_adapter.user_list;

import use_case.UserListOutputData;
import use_case.UserListOutputBoundary;
import view.UserListViewModel;

public class UserListPresenter implements UserListOutputBoundary {
    private final UserListViewModel viewModel;

    public UserListPresenter(UserListViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @Override
    public void prepareSuccessView(UserListOutputData clear) {


    }
}
