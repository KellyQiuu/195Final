package use_case.signup;

public class SignupOutputData {

    private final String username;
    private final boolean isSuccessful;


    public SignupOutputData(String username, boolean isSuccessful) {
        this.username = username;
        this.isSuccessful = isSuccessful;
    }

    public boolean isSuccessful() { return isSuccessful; }

    public String getUsername() {return username; }

}
