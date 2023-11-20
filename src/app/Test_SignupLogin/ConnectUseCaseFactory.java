package app.Test_SignupLogin;

import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupUserAccessInterface;

import java.io.IOException;

public class ConnectUseCaseFactory {
    public static ConnectController createUserConnectUseCase(ConnectViewModel connectViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        ConnectOutputBoundary connectOutputBoundary = new ConnectPresenter( connectViewModel);

        UserFactory userFactory = new UserFactory();
        UserDataAccessObject dao = new UserDataAccessObject(new UserFactory());

        ConnectInputBoundary userConnectInteractor = new ConnectInteractor(connectOutputBoundary,dao
                );
        //TODO: remove fake data and make Connect Clean
        String senderUserName = "FakeKelly";
        String recepientEmail = "qiuwenyu2021@outlook.com";
        return new ConnectController(userConnectInteractor,senderUserName, recepientEmail);
    }
}
