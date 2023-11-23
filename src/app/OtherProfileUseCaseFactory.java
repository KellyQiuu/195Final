package app;

import app.Test_SignupLogin.ConnectUseCaseFactory;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfilePresenter;
import interface_adapter.other_profile.OtherProfileViewModel;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectOutputBoundary;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.other_profile.OtherProfileInputBoundary;
import use_case.other_profile.OtherProfileInteractor;
import use_case.other_profile.OtherProfileOutputBoundary;
import view.OtherProfileView;

import javax.swing.*;
import java.io.IOException;

public class OtherProfileUseCaseFactory {
    private OtherProfileUseCaseFactory(){};

    public static OtherProfileView create(
            ViewManagerModel viewManagerModel,
            OtherProfileViewModel profileViewModel,
            OtherProfileDataAccessInterface otherProfileDataAccessObject,
            ConnectViewModel connectViewModel,
            ConnectDataAccessInterface connectDataAccessObject
    ){
        try {
            OtherProfileController otherProfileController = createOtherProfileUSeCase(viewManagerModel,
                    profileViewModel, otherProfileDataAccessObject);

            OtherProfileView otherProfileView = new OtherProfileView(profileViewModel, otherProfileController, createUserConnectUseCase(connectViewModel, connectDataAccessObject), viewManagerModel);
            return otherProfileView;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error in creating Profile View");
            return null;
        }
    }

    private static OtherProfileController createOtherProfileUSeCase(ViewManagerModel viewManagerModel,
                                                                    OtherProfileViewModel viewModel,
                                                                    OtherProfileDataAccessInterface otherProfileDataAccessObject) throws IOException{
        OtherProfileOutputBoundary otherProfileOutputBoundary = new OtherProfilePresenter(viewModel, viewManagerModel);

        OtherProfileInputBoundary otherProfileInteractor = new OtherProfileInteractor(otherProfileDataAccessObject, otherProfileOutputBoundary);
        return new OtherProfileController(otherProfileInteractor);
    }

    // Takes in the connect factory method.
    public static ConnectController createUserConnectUseCase(
            ConnectViewModel connectViewModel,
            ConnectDataAccessInterface connectDataAccessInterface
    ) {
        ConnectOutputBoundary presenter = new ConnectPresenter(connectViewModel);
        ConnectInputBoundary interactor = new ConnectInteractor(presenter, connectDataAccessInterface);

        return new ConnectController(interactor);
    }
}

