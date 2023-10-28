package app;

import data_access.FileUserDataAccessObject;
import entity.User;
import interface_adapter.UserListController;
import interface_adapter.UserListPresenter;
import interface_adapter.UserListViewModel;
import use_case.UserListDataAccessInterface;
import use_case.UserListInputBoundary;
import use_case.UserListOutputBoundary;
import view.UserListView;

import java.io.IOException;

public class UserListUseCaseFactory {
    public static UserListView create(){
        return null;
    };
    private static UserListController createUserListUseCase(UserListViewModel signupViewModel, UserListDataAccessInterface userListDataAccessObject) throws IOException {
        UserListOutputBoundary signupOutputBoundary = new UserListPresenter(signupViewModel);

        User user = new User();

        UserListInputBoundary UserListInteractor = new UserListInteractor(
                FileUserDataAccessObject, signupOutputBoundary, user);

        return new UserListController(UserListInteractor, userListInteractor);
    }
}
