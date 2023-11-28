package app.UsecaseFactory;

import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginUserAccessInterface;
import view.UserListViewModel;
import view.signup_login.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            UserListViewModel userListViewModel,
            LoginUserAccessInterface userDataAccessObject) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, userListViewModel,userDataAccessObject);
            return new LoginView(loginController, loginViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            UserListViewModel userListViewModel,
            LoginUserAccessInterface userDataAccessObject) throws IOException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel, userListViewModel);

        UserFactory userFactory = new UserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}
