package use_case.login;

import entity.GeneralUser;
import entity.User;

import java.io.IOException;

public class LoginInteractor implements LoginInputBoundary {
    final LoginUserAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void login(LoginInputData loginInputData) throws IOException {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView("Account " + username + " does not exist.");
        } else {
//            String pwd = userDataAccessObject.get(username).getPassword();
            String pwd = userDataAccessObject.getPass(username);
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                GeneralUser user = userDataAccessObject.get2(loginInputData.getUsername());

                LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
                loginPresenter.prepareSuccessView(loginOutputData);




            }
        }

    }
}