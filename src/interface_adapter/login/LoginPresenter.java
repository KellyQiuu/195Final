package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.user_list.UserListState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.user_list.UserSecessionInterface;
import view.UserListViewModel;
import use_case.UserSecession;


public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;

    private final UserListViewModel userListViewModel;

    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoginViewModel loginViewModel,
                          UserListViewModel userListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.userListViewModel = userListViewModel;
    }

    public void prepareSuccessView(LoginOutputData response) {
        UserListState userListState = userListViewModel.getState();
        //userListState.setUsername(response.getUsername());
        System.out.println("(LoginPresenter): current username fetched, "+response.getUsername());
        UserSecession.getInstance().setCurrentUserName(response.getUsername());


        this.userListViewModel.setState(userListState);
        this.userListViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(userListViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }


    public void prepareFailView(String errorMessage) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(errorMessage);
        loginViewModel.firePropertyChanged();
    }

}
