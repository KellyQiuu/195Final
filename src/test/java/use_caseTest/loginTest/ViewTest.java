package use_caseTest.loginTest;

import app.UsecaseFactory.LoginUseCaseFactory;
import app.UsecaseFactory.SignupUseCaseFactory;
import app.UsecaseFactory.UserListUseCaseFactory;
import data_access.PSQLDataAccessObject;
import interface_adapter.login.LoginViewModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.self_profile.SelfProfileViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.user_list.UserListDataAccessInterface;
import view.signup_login.LoginView;
import view.signup_login.SignupView;

import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


import view.UserListViewModel;
import view.UserListView;


public class ViewTest {
    public static void main(String[] args) throws IOException {

        JFrame application = new JFrame("195 final project");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        UserListViewModel userListViewModel = new UserListViewModel();
        OtherProfileViewModel profileViewModel = new OtherProfileViewModel();
        SelfProfileViewModel selfProfileViewModel = new SelfProfileViewModel();

        PSQLDataAccessObject userDataAccessObject;

        try {

            userDataAccessObject = new PSQLDataAccessObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SelfProfileDataAccessInterface selfProfileDataAccessObject = new PSQLDataAccessObject();
        OtherProfileDataAccessInterface otherProfileDataAccessObject;
        try {
            otherProfileDataAccessObject = new PSQLDataAccessObject();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, userListViewModel,userDataAccessObject);
        views.add(loginView, loginView.viewName);


        UserListDataAccessInterface userListDataAccessObject;
        try {

            userListDataAccessObject = new PSQLDataAccessObject();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }

        UserListView userListView = UserListUseCaseFactory.create(
                viewManagerModel,
                userListViewModel,
                profileViewModel,
                userListDataAccessObject,
                otherProfileDataAccessObject,
                selfProfileViewModel,
                selfProfileDataAccessObject
        );
        views.add(userListView, userListView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}