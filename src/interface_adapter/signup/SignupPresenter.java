package interface_adapter.signup;

import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
import view.user_signup_login.SignupLoginView;
import view.user_signup_login.SignupLoginViewModel;

public class SignupPresenter implements SignupOutputBoundary {

    private SignupLoginViewModel viewModel;
    public SignupPresenter(SignupLoginViewModel viewModel) { this.viewModel = viewModel; }

    @Override
    public void prepareFailView(SignupOutputData outputData) {
            viewModel.signupFailure(outputData.getMessage());
    }


    @Override
    public void prepareSuccessView(SignupOutputData outputData) {
        viewModel.signupSuccess();
    }
}
