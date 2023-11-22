package app;

import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectOutputBoundary;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;

import app.Test_SignupLogin.LoginUseCaseFactory;
import app.Test_SignupLogin.SignupUseCaseFactory;
import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.user_list.UserListDataAccessInterface;
import view.OtherProfileView;
import view.signup_login.LoginView;
import view.signup_login.SignupView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


import view.UserListViewModel;
import view.UserListView;


public class Main {
    public static void main(String[] args) throws IOException {
        // Initial Frame Setup =========================================================================================
        JFrame application = new JFrame("CourseMate Connect");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Card layout setup ===========================================================================================
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // ViewModels setup ============================================================================================
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        UserListViewModel userListViewModel = new UserListViewModel();
        OtherProfileViewModel otherProfileViewModel = new OtherProfileViewModel();
        ConnectViewModel connectViewModel = new ConnectViewModel();

        // DAO setup ===================================================================================================
        UserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new UserDataAccessObject(new UserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        OtherProfileDataAccessInterface otherProfileDataAccessObject;
        try {
            otherProfileDataAccessObject = new UserDataAccessObject(new UserFactory());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }

        UserListDataAccessInterface userListDataAccessObject;
        try {
            userListDataAccessObject = new UserDataAccessObject(new UserFactory());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }

        ConnectDataAccessInterface dao = new UserDataAccessObject(new UserFactory());

        // ???? ========================================================================================================
        String senderUsername = "FakeKelly"; // Replace with actual username
        String recipientEmail = "qiuwenyu2021@outlook.com"; // Replace with actual recipient email
        String recipientUsername = "FakeKelly";
        ConnectOutputBoundary dataAccess = new ConnectPresenter(connectViewModel);
        ConnectInteractor connectInteractor = new ConnectInteractor(dataAccess,dao);
        ConnectController connectController = new ConnectController(connectInteractor, recipientEmail);

        // Views Setup =================================================================================================
        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel,
                loginViewModel, loggedInViewModel, userListViewModel,userDataAccessObject);
        UserListView userListView = UserListUseCaseFactory.create(
                viewManagerModel,
                userListViewModel,
                otherProfileViewModel,
                userListDataAccessObject,
                otherProfileDataAccessObject
        );
        OtherProfileView otherProfileView = OtherProfileUseCaseFactory.create(viewManagerModel,
                otherProfileViewModel,
                otherProfileDataAccessObject,
                connectController);
        views.add(otherProfileView, otherProfileView.viewName);
        views.add(userListView, userListView.viewName);
        views.add(signupView, signupView.viewName);
        views.add(loginView, loginView.viewName);

        // Model fire property change ==================================================================================
        viewManagerModel.firePropertyChanged();
        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        // Final setup for the application =============================================================================
        application.pack();
        application.setSize(new Dimension(800, 600)); // Adjust the window size as needed
        application.setLocationRelativeTo(null); // Center the window
        application.setVisible(true);
    }
}

