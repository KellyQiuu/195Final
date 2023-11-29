package use_case.signup;

import entity.User;
import entity.UserFactory;

import java.util.ArrayList;
import java.util.List;


public class SignupInteractor implements SignupInputBoundary {
    private final UserFactory userFactory;
    private final SignupOutputBoundary outputBoundary;
    private final SignupUserAccessInterface signupDataAccess;

    public SignupInteractor(SignupOutputBoundary outputBoundary,
                            SignupUserAccessInterface signupDataAccess,
                            UserFactory userFactory) {
        this.userFactory = userFactory;
        this.outputBoundary = outputBoundary;
        this.signupDataAccess = signupDataAccess;
    }


    @Override
    // TODO: 11/13/2023 message is tentative
    public void signup(SignupInputData signupInputData) {
        if (signupInputData == null) {
            outputBoundary.prepareFailView("Invalid Input");
            return;
        }

        String username = signupInputData.getUsername();
        String password = signupInputData.getPassword();
        String id = signupInputData.getId();
        String email = signupInputData.getEmail();
        List<String> courses = signupInputData.getCourses();


        if (!signupDataAccess.checkValidEmail(email)) {
            outputBoundary.prepareFailView("Please enter a valid email");
            return;
        }

        if(!signupDataAccess.checkValidUsername(username)) {
            outputBoundary.prepareFailView("Username already exists.");
            return;
        }

        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty() ||
                email == null || email.isEmpty() ||
                courses == null || courses.isEmpty()) {
            outputBoundary.prepareFailView("Invalid Input");
            return;
        }

        User newUser = UserFactory.createUser(username, password,"123", email, (ArrayList<String>) courses);


        signupDataAccess.save(newUser);

        outputBoundary.prepareSuccessView(new SignupOutputData(signupInputData.getUsername(), true));
    }
}
