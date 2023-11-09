package use_case.signup;

import entity.User;
import entity.UserFactory;

import java.util.ArrayList;
import java.util.List;


public class SignupInteractor implements SignupInputBoundary {
    private final UserFactory userFactory;
    private final SignupInputBoundary signupPresenter;
    private final SignupUserAccessInterface userDataAccess;



    public SignupInteractor(SignupInputBoundary signupPresenter,
                            SignupUserAccessInterface userDataAccess) {
        this.userFactory = new UserFactory();
        this.signupPresenter = signupPresenter;
        this.userDataAccess = userDataAccess;
    }

    @Override
    public boolean signupSuccess(SignupInputData signupInputData) {
        if (signupInputData == null) {
            return false;
        }

        String username = signupInputData.getUsername();
        String password = signupInputData.getPassword();
        String id = signupInputData.getId();
        String email = signupInputData.getEmail();
        List<String> courses = signupInputData.getCourses();

        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty() ||
                email == null || email.isEmpty() ||
                courses == null || courses.isEmpty()) {
            return false;
        }

        if (!userDataAccess.checkValidEmail(email)) {
            return false; // email address is not valid
        }

        if (!userDataAccess.checkValidUsername(username)) {
            return false; // Username already exists
        }

        User newUser = this.userFactory.creatUser(username, password, id, email, (ArrayList<String>) courses);
        userDataAccess.save(newUser);


        return true;
        // TODO: 10/23/2023 xie presenter
    }
}