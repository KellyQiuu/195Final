package interface_adapter.connect;

import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInputData;

public class ConnectController {
    private final ConnectInputBoundary connectInputBoundary;

    public ConnectController(ConnectInputBoundary connectInputBoundary) {
        this.connectInputBoundary = connectInputBoundary;
    }

    public void onConnectButtonClicked(String senderUsername, String recipientEmail) {
        // Trigger UI to show pop-up and get the free text message
        String freeTextMessage = getFreeTextFromUser();
        ConnectInputData inputData = new ConnectInputData(senderUsername, recipientEmail, freeTextMessage);
        connectInputBoundary.handleConnect(inputData);
    }

    private String getFreeTextFromUser() {
        // Implement the logic to show a pop-up and capture the free text from the user
        return ""; // Return the message entered by the user
    }
}
