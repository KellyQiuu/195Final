package interface_adapter.connect;

import app.UsecaseFactory.ConnectUseCaseFactory;
import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInputData;
import view.ConnectView;

public class ConnectController {
    private final ConnectInputBoundary connectInputBoundary;
    private String recipientEmail; // Could be an email, ID, etc.

    public ConnectController(ConnectInputBoundary connectInputBoundary) {
        this.connectInputBoundary = connectInputBoundary;
    }

    public void initiateConnectionProcess(String recipientEmail) {
        this.recipientEmail = recipientEmail;
        ConnectView connectView = ConnectUseCaseFactory.create(this);
        connectView.setVisible(true);
    }

    public void handleSendEmailClicked(String message) throws Exception {
        ConnectInputData inputData = new ConnectInputData(message);
        connectInputBoundary.handleConnect(inputData, recipientEmail);
    }
}
