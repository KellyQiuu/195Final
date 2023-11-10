package use_case.signup;

/**
 * Application Business Rule layer input boundary.
 */

public interface SignupInputBoundary {
    /**
     * @param signupInputData data of the user input during the signup process.
     */
    void signup(SignupInputData signupInputData);

}
