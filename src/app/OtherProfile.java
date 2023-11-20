package app;

import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectOutputBoundary;
import use_case.other_profile.OtherProfileDataAccessInterface;
import view.OtherProfileView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OtherProfile {
    public static void main(String[] args) throws IOException {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Other Profile Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);


        application.add(views);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        OtherProfileViewModel otherProfileViewModel = new OtherProfileViewModel();
        System.out.println("1 Created PROFILE VIEW MODEL");

        OtherProfileDataAccessInterface profileDataAccessObject;
        try {
            profileDataAccessObject = new UserDataAccessObject(new UserFactory());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
            throw new RuntimeException(e);
        }
        ConnectViewModel connectViewModel = new ConnectViewModel();
        ConnectOutputBoundary dataAccess = new ConnectPresenter(connectViewModel); // Replace with your constructor if different
        ConnectDataAccessInterface dao = new UserDataAccessObject(new UserFactory());
        // Create the ConnectInteractor instance
        ConnectInteractor connectInteractor = new ConnectInteractor(dataAccess,dao);
        System.out.println("2 Created CONNECT INTERACTOR");

        // Assuming sender's username and recipient's email are known for demonstration
        String senderUsername = "FakeKelly"; // Replace with actual username
        String recipientEmail = "qiuwenyu2021@outlook.com"; // Replace with actual recipient email
        String recipientUsername = "FakeKelly";

        // Create the ConnectController instance
        ConnectController connectController = new ConnectController(connectInteractor, senderUsername, recipientEmail);
        System.out.println("3 Created Connect Controller");

        OtherProfileView otherProfileView = OtherProfileUseCaseFactory.create(viewManagerModel,
                otherProfileViewModel,
                profileDataAccessObject,
                connectController);
        System.out.println("4 Created Profile View");

        views.add(otherProfileView, otherProfileView.viewName);
        viewManagerModel.setActiveView(otherProfileView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
