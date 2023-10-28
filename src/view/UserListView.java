package src.view;

import interface_adapter.UserListViewModel;

public class UserListView {
    public final String viewName = "User List";
    private final UserListViewModel userListViewModel;

    public UserListView(UserListViewModel userListViewModel) {
        this.userListViewModel = userListViewModel;
    }
}
