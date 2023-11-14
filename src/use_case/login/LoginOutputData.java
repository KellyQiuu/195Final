package use_case.login;

public class LoginOutputData {

    private final String username;
    private final boolean isSuccessful;


    public LoginOutputData(String username, boolean isSuccessful) {
        this.username = username;
        this.isSuccessful = isSuccessful;
    }

    public boolean isSuccessful() { return isSuccessful; }

    public String getUsername() {return username; }

}
