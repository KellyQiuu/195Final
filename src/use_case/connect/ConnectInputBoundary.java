package use_case.connect;

import java.io.IOException;

public interface ConnectInputBoundary {
    /**
     * Handles the connect process, including sending a message.
     *
     * @param inputData The data required to perform the connect operation,
     *                  including sender's information and the message.
     */
    void handleConnect(ConnectInputData inputData, String recipientEmail) throws Exception;
}
