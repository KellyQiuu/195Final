package interface_adapter.connect;

/**
 * Class representing the state of the "Connect" feature.
 */
public class ConnectState {
    private String connectionStatus;
    private boolean isConnectionInProgress;

    public ConnectState() {
        this.connectionStatus = "";
        this.isConnectionInProgress = false;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public boolean isConnectionInProgress() {
        return isConnectionInProgress;
    }

    public void setConnectionInProgress(boolean connectionInProgress) {
        isConnectionInProgress = connectionInProgress;
    }
}
