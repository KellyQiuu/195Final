package use_case.signup;

public class SignupOutputData {
    private final boolean isSuccessful;
    private final String message;

    public SignupOutputData(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public boolean isSuccessful() { return isSuccessful; }

    public String getMessage() { return message; }

}
