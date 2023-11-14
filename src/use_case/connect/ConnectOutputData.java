package use_case.connect;

/**
 * Data transfer object representing the output of the "Connect" use case.
 */
public class ConnectOutputData {
    private final boolean success;
    private final String message;

    public ConnectOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
