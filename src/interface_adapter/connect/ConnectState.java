package interface_adapter.connect;

/**
 * Class representing the state of the "Connect" feature.
 */
public class ConnectState {
    private boolean isConnectionInProgress;

    public ConnectState() {
        this.isConnectionInProgress = false;
    }

    public boolean isConnectionInProgress() {
        return isConnectionInProgress;
    }

    public void setConnectionInProgress(boolean isConnectionInProgress) {
        this.isConnectionInProgress = isConnectionInProgress;
    }
}
