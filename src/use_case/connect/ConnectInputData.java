package use_case.connect;

/**
 * Data Transfer Object for carrying message data for the connection process.
 */
public class ConnectInputData {
    private final String message; // Message content

    /**
     * Constructs a new instance of ConnectInputData.
     *
     * @param message The message to be sent.
     */
    public ConnectInputData(String message) {
        this.message = message;
    }

    /**
     * Gets the message content.
     *
     * @return The message content.
     */
    public String getMessage() {
        return message;
    }
}
