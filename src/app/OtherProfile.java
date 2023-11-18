package app;

import data_access.UserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfilePresenter;
import interface_adapter.other_profile.OtherProfileViewModel;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectOutputBoundary;
import use_case.other_profile.*;
import view.OtherProfileView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OtherProfile {
    public static void main(String[] args) throws IOException {
        ConnectViewModel connectViewModel = new ConnectViewModel();
        ConnectOutputBoundary dataAccess = new ConnectPresenter(connectViewModel); // Replace with your constructor if different
        ConnectDataAccessInterface dao = new UserDataAccessObject();
        // Create the ConnectInteractor instance
        ConnectInteractor connectInteractor = new ConnectInteractor(dataAccess,dao);

        // Assuming sender's username and recipient's email are known for demonstration
        String senderUsername = "FakeKelly"; // Replace with actual username
        String recipientEmail = "qiuwenyu2021@outlook.com"; // Replace with actual recipient email

        // Create the ConnectController instance
        ConnectController connectController = new ConnectController(connectInteractor, senderUsername, recipientEmail);

        JFrame application = new JFrame("Profile Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        OtherProfileViewModel opViewModel = new OtherProfileViewModel();
        opViewModel.setUser(dao.getUserByUsername("user1"));
        OtherProfileOutputBoundary dataaccess = new OtherProfilePresenter(opViewModel, viewManagerModel);

        OtherProfileDataAccessInterface daoo = new UserDataAccessObject();

        OtherProfileInteractor otherProfileInteractor = new OtherProfileInteractor(daoo, dataaccess);

        OtherProfileController otherProfileController = new OtherProfileController(otherProfileInteractor);

        OtherProfileView view = new OtherProfileView(opViewModel, otherProfileController, connectController);
        application.pack();
        application.setVisible(true);

    }
}
