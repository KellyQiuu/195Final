package interface_adapter.login;

//import interface_adapter.logged_in.LoggedInState;
//import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputData;


public class LoginPresenter {

    private final LoginViewModel loginViewModel;

    private ViewManagerModel viewManagerModel;


    public LoginPresenter(ViewManagerModel viewManagerModel,
//                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
//        this.loggedInViewModel = loggedInViewModel;
    }

    public void prepareSuccessView(LoginOutputData response) {
        // switch to the logged in view
    }

    public void prepareFailView(String errorMessage) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(errorMessage);
        loginViewModel.firePropertyChanged();
    }

}
