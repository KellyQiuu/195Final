package interface_adapter.connect;

/**
 * ViewModel for managing and presenting connection status in the UI.
 */
public class ConnectViewModel {
    private String connectionStatus;

    /**
     * Gets the current connection status.
     *
     * @return The current connection status.
     */
    public String getConnectionStatus() {
        return connectionStatus;
    }

    /**
     * Sets the connection status and notifies the view of this change.
     *
     * @param connectionStatus The new connection status.
     */
    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
