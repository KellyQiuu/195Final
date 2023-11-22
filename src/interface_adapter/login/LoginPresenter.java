package interface_adapter.login;

import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.user_list.UserListState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import view.UserListViewModel;
import use_case.UserSecession;


public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private final UserListViewModel userListViewModel;

    private ViewManagerModel viewManagerModel; // 1111111111


    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel,
                          UserListViewModel userListViewModel) {  // 111111
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.userListViewModel = userListViewModel; // 11111111
    }

//    public void prepareSuccessView(LoginOutputData response) {
//        LoggedInState loggedInState = loggedInViewModel.getState();
//        loggedInState.setUsername(response.getUsername());
//        this.loggedInViewModel.setState(loggedInState);
//        this.loggedInViewModel.firePropertyChanged();
//
//        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
//        this.viewManagerModel.firePropertyChanged();
//    }

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
