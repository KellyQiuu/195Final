package use_case;

import data_access.FileUserDataAccessObject;
import entity.User;

public class UserListInteractor implements UserListInputBoundary{
    final UserListInputBoundary userListInputBoundary;
    FileUserDataAccessObject userDataAccessObject;
    UserListOutputBoundary userListOutputBoundary;
    User user;

    public UserListInteractor(UserListInputBoundary userListInputBoundary, FileUserDataAccessObject userdao,
                              UserListOutputBoundary userListOutputBoundary,
                              User user){
        this.userListInputBoundary = userListInputBoundary;
        this.user = user;
        this.userDataAccessObject = userdao;
        this.userListOutputBoundary = userListOutputBoundary;

    }
    @Override
    public void execute() {

    }
}
