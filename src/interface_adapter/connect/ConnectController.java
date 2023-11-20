package interface_adapter.connect;

import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInputData;

public class ConnectController {
    private final ConnectInputBoundary connectInputBoundary;
    private final String recipientIdentifier; // Could be an email, ID, etc.

    public ConnectController(ConnectInputBoundary connectInputBoundary, String recipientIdentifier) {
        this.connectInputBoundary = connectInputBoundary;
        this.recipientIdentifier = recipientIdentifier;
    }

    public void handleSendEmailClicked(String message) {
        ConnectInputData inputData = new ConnectInputData(message);
        connectInputBoundary.handleConnect(inputData, recipientIdentifier);
    }
}
