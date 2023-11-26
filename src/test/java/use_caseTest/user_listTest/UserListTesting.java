package use_caseTest.user_listTest;

import app.UsecaseFactory.ConnectUseCaseFactory;
import app.UsecaseFactory.OtherProfileUseCaseFactory;
import app.UsecaseFactory.UserListUseCaseFactory;
import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.self_profile.SelfProfileViewModel;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.user_list.UserListDataAccessInterface;
import view.OtherProfileView;
import view.UserListView;
import view.UserListViewModel;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
        SelfProfileViewModel selfProfileViewModel = new SelfProfileViewModel();
        UserListDataAccessInterface userListDataAccessObject;
        try {
            userListDataAccessObject = new UserDataAccessObject(new UserFactory()); // TODO: 11/18/2023 delete the argument
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }
        SelfProfileDataAccessInterface selfProfileDataAccessObject = new UserDataAccessObject(new UserFactory());
        UserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new UserDataAccessObject(new UserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OtherProfileDataAccessInterface otherProfileDataAccessObject;
        try {
            otherProfileDataAccessObject = new UserDataAccessObject(new UserFactory()); // TODO: 11/18/2023 delete the argument
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }
        System.out.println("DataAccessCreated from Main");
        ConnectViewModel connectViewModel = new ConnectViewModel();
        //ConnectOutputBoundary dataAccess = new ConnectPresenter(connectViewModel); // Replace with your constructor if different
        //ConnectDataAccessInterface dao = new UserDataAccessObject(new UserFactory());
        //ConnectInteractor connectInteractor = new ConnectInteractor(dataAccess,dao);
        ConnectController connectController = ConnectUseCaseFactory.createUserConnectUseCase(connectViewModel, userDataAccessObject);
        // Create the ConnectInteractor instance
        String senderUsername = "FakeKelly"; // Replace with actual username
        String recipientEmail = "qiuwenyu2021@outlook.com"; // Replace with actual recipient email
        String recipientUsername = "FakeKelly";

        // Create the ConnectController instance
        //ConnectController connectController = new ConnectController(connectInteractor);
        System.out.println("3 Created Connect Controller");

        OtherProfileView otherProfileView = OtherProfileUseCaseFactory.create(viewManagerModel,
                otherProfileViewModel,
                otherProfileDataAccessObject,
                connectViewModel, new UserDataAccessObject(new UserFactory()));
        otherProfileView.setVisible(false);


        // Creating and adding UserListView
        UserListView userListView = UserListUseCaseFactory.create(
                viewManagerModel,
                userListViewModel,
                otherProfileViewModel,
                userListDataAccessObject,
                otherProfileDataAccessObject,
                selfProfileViewModel,
                selfProfileDataAccessObject
        );

        if (userListView != null) {
            views.add(userListView, userListView.viewName);
            views.add(userListView, userListView.getViewName()); // Make sure this is correct
            System.out.println("Added UserListView with name2: " + userListView.viewName);
            viewManagerModel.setActiveView(userListView.getViewName()); // Set the active view
            viewManagerModel.firePropertyChanged(); // Notify the view manager
        } else {
            throw new IllegalStateException("UserListView could not be initialized.");
        }
        otherProfileView.setVisible(true);


        views.add(otherProfileView, otherProfileView.viewName);

        viewManagerModel.firePropertyChanged();


        application.pack();
        application.setSize(new Dimension(800, 600)); // Adjust the window size as needed
        application.setLocationRelativeTo(null); // Center the window
        application.setVisible(true);
    }
}
