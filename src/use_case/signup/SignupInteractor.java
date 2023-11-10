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
    // TODO: 11/10/2023 message is tentative
    public void signup(SignupInputData signupInputData) {
        if (signupInputData == null) {
            outputBoundary.presentSignupResult(new SignupOutputData(false, "Invalid Input"));
            return;
        }

        String username = signupInputData.getUsername();
        String password = signupInputData.getPassword();
        String id = signupInputData.getId();
        String email = signupInputData.getEmail();
        List<String> courses = signupInputData.getCourses();


        // TODO: 11/10/2023 use api?
        if (!signupDataAccess.checkValidEmail(email)) {
            return;
        }

        if(!signupDataAccess.checkValidUsername(username)) {
            outputBoundary.presentSignupResult(new SignupOutputData(false, "Username already exists."));
            return;
        }

        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty() ||
                email == null || email.isEmpty() ||
                courses == null || courses.isEmpty()) {
            outputBoundary.presentSignupResult(new SignupOutputData(false, "Empty Input"));
            return;
        }

        User newUser = UserFactory.creatUser(username, password, id, email, (ArrayList<String>) courses);
        signupDataAccess.save(newUser);

        outputBoundary.presentSignupResult(new SignupOutputData(true, "Signup successful"));


    }

//    @Override
//    public boolean signup(SignupInputData signupInputData) {
//        if (signupInputData == null) {
//            return false;
//        }
//
//        String username = signupInputData.getUsername();
//        String password = signupInputData.getPassword();
//        String id = signupInputData.getId();
//        String email = signupInputData.getEmail();
//        List<String> courses = signupInputData.getCourses();
//
//        if (username == null || username.isEmpty() ||
//                password == null || password.isEmpty() ||
//                email == null || email.isEmpty() ||
//                courses == null || courses.isEmpty()) {
//            return false;
//        }
//
//        if (!userDataAccess.checkValidEmail(email)) {
//            return false; // email address is not valid
//        }
//
//        if (!userDataAccess.checkValidUsername(username)) {
//            return false; // Username already exists
//        }
//
//        User newUser = this.userFactory.creatUser(username, password, id, email, (ArrayList<String>) courses);
//        userDataAccess.save(newUser);
//
//
//        return true;
//        // TODO: 10/23/2023 xie presenter

}