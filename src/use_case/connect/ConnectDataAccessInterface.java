package use_case.connect;

import entity.User;

public interface ConnectDataAccessInterface {
    User getCurrentUser(); // Get the currently logged-in user
    String getRecipientEmail(String identifier); // Get the recipient's email by some identifier
}
