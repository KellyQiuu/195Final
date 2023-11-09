package use_case.signup;

/**
 * Application Business Rule layer input boundary.
 */

public interface SignupInputBoundary {
    /**
     * @param signupInputData data of the user input during the signup process.
     * @return true if and only the user have successful signup for an account.
     */
    boolean signupSuccess(SignupInputData signupInputData);

}
