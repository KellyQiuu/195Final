package app;

import data_access.UserDataAccessObject;
import interface_adapter.connect.ConnectController;
import view.ConnectView;
import use_case.connect.ConnectInteractor;
//import service.EmailService; // Replace with your actual email service implementation
import use_case.connect.ConnectDataAccessInterface; // Replace with your actual data access implementation

import java.io.IOException;

public class Connect {

    public static void main(String[] args) throws IOException {
        // Create an instance of UserDataAccessObject
        UserDataAccessObject dataAccess = new UserDataAccessObject(); // Replace with your constructor if different

        // Create the ConnectInteractor instance
        ConnectInteractor connectInteractor = new ConnectInteractor(dataAccess);

        // Assuming sender's username and recipient's email are known for demonstration
        String senderUsername = "sender@example.com"; // Replace with actual username
        String recipientEmail = "recipient@example.com"; // Replace with actual recipient email

        // Create the ConnectController instance
        ConnectController connectController = new ConnectController(connectInteractor, senderUsername, recipientEmail);

        // Create and show the ConnectView
        ConnectView connectView = new ConnectView(connectController);
        connectView.setVisible(true); // Make sure to set the view visible
    }
}