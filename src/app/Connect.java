package app;

import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;
import use_case.connect.ConnectOutputBoundary;
import view.ConnectView;
import use_case.connect.ConnectInteractor;
//import service.EmailService; // Replace with your actual email service implementation
import use_case.connect.ConnectDataAccessInterface; // Replace with your actual data access implementation

import java.io.IOException;

public class Connect {

    public static void main(String[] args) throws IOException {
        // Create an instance of UserDataAccessObject
        ConnectViewModel connectViewModel = new ConnectViewModel();
        ConnectOutputBoundary dataAccess = new ConnectPresenter(connectViewModel); // Replace with your constructor if different
        ConnectDataAccessInterface dao = new UserDataAccessObject(new UserFactory()); // TODO: 11/18/2023 delete the argument
        // Create the ConnectInteractor instance
        ConnectInteractor connectInteractor = new ConnectInteractor(dataAccess,dao);

        // Assuming sender's username and recipient's email are known for demonstration
        String senderUsername = "FakeKelly"; // Replace with actual username
        String recipientEmail = "qiuwenyu2021@outlook.com"; // Replace with actual recipient email

        // Create the ConnectController instance
        ConnectController connectController = new ConnectController(connectInteractor);

        // Create and show the ConnectView
        ConnectView connectView = new ConnectView(connectController);
        connectView.setVisible(true); // Make sure to set the view visible
    }
}