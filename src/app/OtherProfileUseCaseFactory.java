package app;

import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfilePresenter;
import interface_adapter.other_profile.OtherProfileViewModel;
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
            ConnectController connectController
    ){
        try {
            OtherProfileController otherProfileController = createOtherProfileUSeCase(viewManagerModel,
                    profileViewModel, otherProfileDataAccessObject);

            OtherProfileView otherProfileView = new OtherProfileView(profileViewModel, otherProfileController, connectController, viewManagerModel);
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
}

