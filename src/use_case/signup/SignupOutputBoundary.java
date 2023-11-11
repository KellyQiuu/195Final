package use_case.signup;

public interface SignupOutputBoundary {
    void prepareFailView(SignupOutputData outputData);

    void prepareSuccessView(SignupOutputData outputData);
}
