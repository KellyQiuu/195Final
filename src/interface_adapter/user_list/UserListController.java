package interface_adapter.user_list;

import use_case.user_list.UserListInputBoundary;

import java.io.IOException;

public class UserListController {
    final UserListInputBoundary userListInteractor;

    public UserListController(UserListInputBoundary userListInteractor) {
        this.userListInteractor = userListInteractor;
    }

    public void execute() throws IOException {
        //TODO;
        userListInteractor.execute();
    }
}
