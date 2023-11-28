package app;

import app.UsecaseFactory.*;
import interface_adapter.self_profile.SelfProfileViewModel;
import use_case.connect.ConnectDataAccessInterface;
import interface_adapter.connect.ConnectViewModel;

import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.login.LoginViewModel;
//import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.user_list.UserListDataAccessInterface;
import view.*;
import view.signup_login.LoginView;
import view.signup_login.MainPageView;
import view.signup_login.SignupView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    // Refactored setup methods
    public static JFrame createApplicationFrame() {
        JFrame application = new JFrame("CourseMate Connect");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setSize(new Dimension(900, 600)); // Adjust the window size as needed
        application.setLocationRelativeTo(null); // Center the window
        return application;
    }

    public static JPanel createCardLayoutPanel(CardLayout cardLayout) {
	    return new JPanel(cardLayout);
    }

    public static void main(String[] args) throws IOException {
        // Initial Frame Setup =========================================================================================
        JFrame application = createApplicationFrame();

        // Card layout setup ===========================================================================================
        CardLayout cardLayout = new CardLayout();
        JPanel views = createCardLayoutPanel(cardLayout);
        application.add(views);

        // ViewModels setup ============================================================================================
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
        LoginViewModel loginViewModel = new LoginViewModel();
//        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        UserListViewModel userListViewModel = new UserListViewModel();

        OtherProfileViewModel otherProfileViewModel = new OtherProfileViewModel();
        SelfProfileViewModel selfProfileViewModel = new SelfProfileViewModel();
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

        SelfProfileDataAccessInterface selfProfileDataAccessObject = new UserDataAccessObject(new UserFactory());

        UserListDataAccessInterface userListDataAccessObject;
        try {
            userListDataAccessObject = new UserDataAccessObject(new UserFactory());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }

        ConnectDataAccessInterface connectDataAccessObject = new UserDataAccessObject(new UserFactory());

        // Views Setup =================================================================================================
        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel,
                loginViewModel, userListViewModel,userDataAccessObject);
        UserListView userListView = UserListUseCaseFactory.create(
                viewManagerModel,
                userListViewModel,
                otherProfileViewModel,
                userListDataAccessObject,
                otherProfileDataAccessObject,
                selfProfileViewModel,
                selfProfileDataAccessObject
        );
        OtherProfileView otherProfileView = OtherProfileUseCaseFactory.create(viewManagerModel,
                otherProfileViewModel,
                otherProfileDataAccessObject,
                connectViewModel,
                connectDataAccessObject);
        SelfProfileView selfProfileView = SelfProfileUseCaseFactory.create(viewManagerModel,
                selfProfileViewModel,
                selfProfileDataAccessObject);
	    assert otherProfileView != null;
	    views.add(otherProfileView, otherProfileView.viewName);
	    assert userListView != null;
	    views.add(userListView, userListView.viewName);
	    assert signupView != null;
	    views.add(signupView, signupView.viewName);
	    assert loginView != null;
	    views.add(loginView, loginView.viewName);
        views.add(selfProfileView, selfProfileView.viewName);

        MainPageView mainPageView = new MainPageView(cardLayout, views, signupView, loginView);
        views.add(mainPageView, "MainPageView"); // Add MainPageView to CardLayout

        // Model fire property change ==================================================================================
        viewManagerModel.firePropertyChanged();
//        viewManagerModel.setActiveView(signupView.viewName); ////////////////////
        viewManagerModel.setActiveView("MainPageView");
        viewManagerModel.firePropertyChanged();

        // Final setup for the application =============================================================================
        application.pack();
        application.setSize(new Dimension(900, 600)); // Adjust the window size as needed
        application.setLocationRelativeTo(null); // Center the window
        application.setVisible(true);
    }
}

