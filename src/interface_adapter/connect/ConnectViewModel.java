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
        notifyView(); // Notify the view of the status change
    }

    /**
     * Notifies the view about a change in the connection status.
     * This method should be implemented to use the appropriate mechanism
     * for updating the view, such as data binding or the observer pattern.
     */
    private void notifyView() {
        // Implement the notification mechanism here
    }
}
