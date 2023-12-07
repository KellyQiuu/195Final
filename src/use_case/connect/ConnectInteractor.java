package use_case.connect;

import entity.GeneralUser;
import entity.User;
import use_case.email_user.EmailService;
import use_case.UserSecession;


public class ConnectInteractor implements ConnectInputBoundary {
    private final ConnectOutputBoundary outputBoundary;
    private final ConnectDataAccessInterface dataAccess;

    public ConnectInteractor(ConnectOutputBoundary outputBoundary, ConnectDataAccessInterface dataAccess) {
        this.outputBoundary = outputBoundary;
        this.dataAccess = dataAccess;
    }

    @Override
    public void handleConnect(ConnectInputData inputData, String recipientEmail) throws Exception {
        String currentUsername = UserSecession.getInstance().getCurrentUserName();
        GeneralUser currentUser = dataAccess.get(currentUsername);
        if (currentUser == null || recipientEmail == null) {
            outputBoundary.onConnectionResult(new ConnectOutputData(false, "User information not found."));
            return;
        }

            // Assuming EmailService is correctly implemented and not static
        EmailService emailService = new EmailService();
        String emailContent = inputData.getMessage();
        emailService.sendEmail(currentUser, recipientEmail, emailContent);
        outputBoundary.onConnectionResult(new ConnectOutputData(true, "Email sent successfully."));
    }
}
