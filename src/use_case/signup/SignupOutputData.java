package use_case.signup;

public class SignupOutputData {

    private final String username;
    private final boolean isSuccessful;
    private final String message;


    public SignupOutputData(String username, boolean isSuccessful, String message) {
        this.username = username;
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public boolean isSuccessful() { return isSuccessful; }

    public String getMessage() { return message; }

    public String getUsername() {return username; }

}
