package app.Test_SignupLogin;
import javax.swing.*;
import java.awt.*;

import app.OtherProfileUseCaseFactory;
import app.UserListUseCaseFactory;
import data_access.FileUserDataAccessObject;
import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.user_list.UserListController;
import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInteractor;
import use_case.user_list.UserListDataAccessInterface;

import view.*;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static app.Test_SignupLogin.ConnectUseCaseFactory.createUserConnectUseCase;

public class UserListTesting {
    public static void main(String[] args) throws IOException {
        // The main application window.
        JFrame application = new JFrame("User Management System");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Using CardLayout to manage different views
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track and manages which view is currently showing
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // ViewModels for the user list and other profile views
        UserListViewModel userListViewModel = new UserListViewModel();
        OtherProfileViewModel otherProfileViewModel = new OtherProfileViewModel();
        UserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new UserDataAccessObject(new UserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DataAccessCreated from Main");
        ConnectViewModel connectViewModel = new ConnectViewModel();

        ConnectController connectController = createUserConnectUseCase(viewManagerModel,connectViewModel,userDataAccessObject);
        //TODO:make this connect controler dealed with (NEW)

        // Creating and adding UserListView
        UserListView userListView = UserListUseCaseFactory.create(
                viewManagerModel,
                userListViewModel,
                otherProfileViewModel,
                userDataAccessObject
        );
        views.add(userListView, userListView.viewName);
        System.out.println("UserList View Added");

        // Creating and adding OtherProfileView
        // OtherProfileView otherProfileView = OtherProfileUseCaseFactory.create(
        //        viewManagerModel, otherProfileViewModel, userDataAccessObject, connectController
        //);
        //views.add(otherProfileView, otherProfileView.viewName);
        //System.out.println("OtherProfile View Added");

        // Set the initial view to user list view
        viewManagerModel.setActiveView(userListView.viewName);
        cardLayout.show(views, userListView.viewName); // Show the UserListView as initial view

        // Finalize and show the application window
        application.pack();
        application.setVisible(true);
    }
}
