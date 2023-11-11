package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import java.util.ArrayList;

public class SignupController {

    final SignupInputBoundary interactor;

    public SignupController(SignupInputBoundary interactor) {
        this.interactor = interactor;
    }
    public void handleSignup(String username, String password, String id, String email,
                             ArrayList<String> courses) {
        SignupInputData signupInputData = new SignupInputData(username,
                password,
                id,
                email,
                courses);
        interactor.signup(signupInputData);
    }
}
