package interface_adapter.logged_in;

public class LoggedInState {
    private String username = "";

    public LoggedInState(LoggedInState copy) { username = copy.username; }

    public LoggedInState() {}

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
