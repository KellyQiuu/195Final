package interface_adapter.connect;

public class ConnectViewModel {
    private String connectionStatus;

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
        // Notify the view about the status change, for example through data binding or an observer
    }
}
