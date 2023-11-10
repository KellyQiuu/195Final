package interface_adapter.signup;

import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
import view.user_signup_login.SignupView;

public class SignupPresenter implements SignupOutputBoundary {

    private SignupView signupView;

    public SignupPresenter(SignupView signupView) {
        this.signupView = signupView;
    }

    public void presentSignupResult(SignupOutputData outputData) {
        if (outputData.isSuccessful()) {
            // Display success message
            signupView.Success(outputData.getMessage());
        } else {
            // Display error message based on the failure reason
            signupView.showError(outputData.getMessage());
        }
    }

}
