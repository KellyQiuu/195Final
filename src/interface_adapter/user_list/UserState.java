package interface_adapter.user_list;

public class UserState{
    private String username = "";
    private String usernameError = null;

    public UserState(){}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
