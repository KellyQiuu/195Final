package interface_adapter.user_list;

import entity.User;
import use_case.user_list.UserListOutputData;
import use_case.user_list.UserListOutputBoundary;
import view.UserListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserListPresenter implements UserListOutputBoundary {

    private List<UserViewModel> viewModel;

    public UserListPresenter(List<UserViewModel> viewModel1) {
        this.viewModel = viewModel1;



    }


    @Override
    public void prepareSuccessView(UserListOutputData sortedUsers) {

        viewModel = sortedUsers.getSortedUsers().stream()
                .map(user -> new UserViewModel(user.getName()))
                .collect(Collectors.toList());

    }

    public List<UserViewModel> getUserViewModels() {
        return viewModel;
    }
}
