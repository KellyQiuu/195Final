package use_case.connect;

import entity.User;
import use_case.email_user.EmailService;

public class ConnectInteractor implements ConnectInputBoundary {

    private final ConnectOutputBoundary outputBoundary;
    private final ConnectDataAccessInterface connectDataAccess;
    private final EmailService emailService; // Instance variable

    public ConnectInteractor(ConnectOutputBoundary outputBoundary,
                             ConnectDataAccessInterface connectDataAccess,
                             EmailService emailService) {
        this.outputBoundary = outputBoundary;
        this.connectDataAccess = connectDataAccess;
        this.emailService = emailService; // Assign to instance variable
    }

    @Override
    public void handleConnect(ConnectInputData inputData) {
        User sender = connectDataAccess.getUserByUsername(inputData.getSenderUsername());
        if (sender == null) {
            outputBoundary.onConnectionResult(new ConnectOutputData(false, "Sender user not found."));
            return;
        }

        try {
            String personalInfo = constructPersonalInfo(sender);
            String emailContent = inputData.getMessage() + "\n\n" + personalInfo;
            emailService.sendEmail(inputData.getRecipientEmail(), "Connection Request", emailContent); // Use instance variable
            outputBoundary.onConnectionResult(new ConnectOutputData(true, "Email sent successfully."));
        } catch (Exception e) {
            outputBoundary.onConnectionResult(new ConnectOutputData(false, "Failed to send email: " + e.getMessage()));
        }
    }

    private String constructPersonalInfo(User user) {
        // Construct the personal information part of the email content
        return "Name: " + user.getName() +
                "\nEmail: " + user.getEmail() +
                "\nCourses: " + String.join(", ", user.getCourses());
    }
}
