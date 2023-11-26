package app.UsecaseFactory;

import interface_adapter.ViewManagerModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfilePresenter;
import interface_adapter.self_profile.SelfProfileViewModel;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.self_profile.SelfProfileInputBoundary;
import use_case.self_profile.SelfProfileInteractor;
import use_case.self_profile.SelfProfileOutputBoundary;
import view.SelfProfileView;

public class SelfProfileUseCaseFactory {
    private SelfProfileUseCaseFactory() {};

    public static SelfProfileView create(
            ViewManagerModel viewManagerModel,
            SelfProfileViewModel selfProfileViewModel,
            SelfProfileDataAccessInterface selfProfileDataAccessObject
    ){
        SelfProfileController selfProfileController = createSelfProfileUseCase(viewManagerModel,
                selfProfileViewModel, selfProfileDataAccessObject);
        SelfProfileView selfProfileView = new SelfProfileView(viewManagerModel, selfProfileViewModel, selfProfileController);
        return selfProfileView;
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
