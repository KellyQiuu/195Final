package use_case.connect;

import entity.User;
import use_case.email_user.EmailService;

public class ConnectInteractor implements ConnectInputBoundary {
    private final ConnectOutputBoundary outputBoundary;
    private final ConnectDataAccessInterface dataAccess;

    public ConnectInteractor(ConnectOutputBoundary outputBoundary, ConnectDataAccessInterface dataAccess) {
        this.outputBoundary = outputBoundary;
        this.dataAccess = dataAccess;
    }

    @Override
    public void handleConnect(ConnectInputData inputData, String recipientIdentifier) {
        User currentUser = dataAccess.getCurrentUser();
        String recipientEmail = dataAccess.getRecipientEmail(recipientIdentifier);

        if (currentUser == null || recipientEmail == null) {
            outputBoundary.onConnectionResult(new ConnectOutputData(false, "User information not found."));
            return;
        }

        try {
            // Assuming EmailService is correctly implemented and not static
            EmailService emailService = new EmailService();
            String emailContent = inputData.getMessage();
            emailService.sendEmail(currentUser.getEmail(), recipientEmail, emailContent);
            outputBoundary.onConnectionResult(new ConnectOutputData(true, "Email sent successfully."));
        } catch (Exception e) {
            outputBoundary.onConnectionResult(new ConnectOutputData(false, "Failed to send email: " + e.getMessage()));
        }
    }
}
