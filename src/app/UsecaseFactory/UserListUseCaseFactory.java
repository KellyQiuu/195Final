package app.UsecaseFactory;

import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfilePresenter;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfilePresenter;
import interface_adapter.self_profile.SelfProfileViewModel;
import interface_adapter.user_list.UserListController;
import interface_adapter.user_list.UserListPresenter;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.other_profile.OtherProfileInputBoundary;
import use_case.other_profile.OtherProfileInteractor;
import use_case.other_profile.OtherProfileOutputBoundary;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.self_profile.SelfProfileInputBoundary;
import use_case.self_profile.SelfProfileInteractor;
import use_case.self_profile.SelfProfileOutputBoundary;
import use_case.user_list.UserListDataAccessInterface;
import use_case.user_list.UserListInputBoundary;
import use_case.user_list.UserListInteractor;
import use_case.user_list.UserListOutputBoundary;
import view.UserListView;
import view.UserListViewModel;

import javax.swing.*;
import java.io.IOException;

public class UserListUseCaseFactory {
    //prevent instantiation
    private UserListUseCaseFactory(){};

    public static UserListView create(
            ViewManagerModel viewManagerModel,
            UserListViewModel viewModel,
            OtherProfileViewModel profileViewModel,
            UserListDataAccessInterface userListDataAccessObject,
            OtherProfileDataAccessInterface otherProfileDataAccessObject,
            SelfProfileViewModel selfProfileViewModel,
            SelfProfileDataAccessInterface selfProfileDataAccessObject
    ){
        try {
            UserListController userListController = createUserListUseCase(viewManagerModel, viewModel,
                    profileViewModel, userListDataAccessObject);
            return new UserListView(viewModel,userListController, createOtherProfileUSeCase(viewManagerModel,
                    profileViewModel, otherProfileDataAccessObject), createSelfProfileUseCase(viewManagerModel,selfProfileViewModel,
                    selfProfileDataAccessObject),viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");

            return null;
    }

}

    private static UserListController createUserListUseCase(ViewManagerModel viewManagerModel,
                                                 UserListViewModel viewModel,
                                                 OtherProfileViewModel profileViewModel,
                                                 UserListDataAccessInterface userListDataAccessObject)throws IOException {

        UserListOutputBoundary userlistOutputBoundary = new UserListPresenter(viewManagerModel,profileViewModel , viewModel);

        UserFactory userFactory = new UserFactory();

        UserListInputBoundary userListInteractor = new UserListInteractor(userListDataAccessObject,userlistOutputBoundary);
        return new UserListController(userListInteractor);
    }

    private static OtherProfileController createOtherProfileUSeCase(ViewManagerModel viewManagerModel,
                                                                    OtherProfileViewModel viewModel,
                                                                    OtherProfileDataAccessInterface otherProfileDataAccessObject) throws IOException {
        OtherProfileOutputBoundary otherProfileOutputBoundary = new OtherProfilePresenter(viewModel, viewManagerModel);

        OtherProfileInputBoundary otherProfileInteractor = new OtherProfileInteractor(otherProfileDataAccessObject, otherProfileOutputBoundary);
        System.out.println("Reached the otherprofile controller");
        return new OtherProfileController(otherProfileInteractor);
    }

    private static SelfProfileController createSelfProfileUseCase(ViewManagerModel viewManagerModel,
                                                                  SelfProfileViewModel selfProfileViewModel,
                                                                  SelfProfileDataAccessInterface selfProfileDataAccessObject) {
        SelfProfileOutputBoundary selfProfileOutputBoundary = new SelfProfilePresenter(selfProfileViewModel,
                viewManagerModel);
        SelfProfileInputBoundary selfProfileInteractor = new SelfProfileInteractor(selfProfileDataAccessObject, selfProfileOutputBoundary);
        return new SelfProfileController(selfProfileInteractor);
    }
}
