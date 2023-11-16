package use_case.connect;

/**
 * Data transfer object representing the output of the "Connect" use case.
 */
public class ConnectOutputData {
    private final boolean success;
    private final String message;

    /**
     * Constructs a new ConnectOutputData instance.
     *
     * @param success Indicates whether the connection attempt was successful.
     * @param message A message describing the result of the connection attempt.
     * @throws IllegalArgumentException if message is null.
     */
    public ConnectOutputData(boolean success, String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null.");
        }
        this.success = success;
        this.message = message;
    }

    /**
     * Checks if the connection attempt was successful.
     *
     * @return true if successful, false otherwise.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Gets the message describing the connection attempt result.
     *
     * @return The result message.
     */
    public String getMessage() {
        return message;
    }
}
