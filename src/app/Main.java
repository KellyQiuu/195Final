package app;

import data_access.FileUserDataAccessObject;
import data_access.UserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfileViewModel;
import use_case.SessionManagerInteractor;
import entity.User;
import entity.UserFactory;

import java.util.ArrayList;
import use_case.email_user.EmailService;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.self_profile.SelfProfileInputBoundary;
import use_case.self_profile.SelfProfileInteractor;
import use_case.user_list.UserListDataAccessInterface;
import view.UserListView;
import view.UserListViewModel;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {

    //Initialization
    //// This setup code would typically go in your main method or application initialization logic
    //
    //// Create the dependencies of the ProfileController
    //ProfileInputBoundary profileInteractor = new ProfileInteractor(/* dependencies */);
    //EmailService emailService = new EmailService(/* your SendGrid API key */);
    //ProfileView profileView = new ProfileView(/* ProfileViewModel */, /* ProfileController */);
    //
    //// Create the ProfileController
    //ProfileController profileController = new ProfileController(profileInteractor, emailService, profileView);
    //
    //// Now that ProfileController is created, you must set it in the ProfileView
    //profileView.setController(profileController);
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("User List Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views are in the ViewModels.
        UserListViewModel userListViewModel = new UserListViewModel();
        OtherProfileViewModel profileViewModel = new OtherProfileViewModel();

        // DataAccess object for user list
        UserListDataAccessInterface userListDataAccessObject;
        try {
            userListDataAccessObject = new UserDataAccessObject(new UserFactory()); // TODO: 11/18/2023 delete the argument
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }
        OtherProfileDataAccessInterface otherProfileDataAccessObject;
        try {
            otherProfileDataAccessObject = new UserDataAccessObject(new UserFactory()); // TODO: 11/18/2023 delete the argument
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }

        // Create and add the User List view to the views panel
        UserListView userListView = UserListUseCaseFactory.create(
                viewManagerModel,
                userListViewModel,
                profileViewModel,
                userListDataAccessObject,
                otherProfileDataAccessObject
        );

        if (userListView != null) {
            views.add(userListView, userListView.viewName);
            System.out.println("Added UserListView with name1: " + userListView.viewName); // Debugging line
        }

        if (userListView != null) {
            views.add(userListView, userListView.getViewName()); // Make sure this is correct
            System.out.println("Added UserListView with name2: " + userListView.viewName);
            viewManagerModel.setActiveView(userListView.getViewName()); // Set the active view
            viewManagerModel.firePropertyChanged(); // Notify the view manager
        } else {
            throw new IllegalStateException("UserListView could not be initialized.");
        }

        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setSize(new Dimension(800, 600)); // Adjust the window size as needed
        application.setLocationRelativeTo(null); // Center the window
        application.setVisible(true);
    }
}

