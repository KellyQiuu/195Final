package src.interface_adapter;

import use_case.UserListInputBoundary;

public class UserListController {
    final UserListInputBoundary userListInteractor;

    public UserListController(UserListInputBoundary userListInteractor) {
        this.userListInteractor = userListInteractor;
    }
}
