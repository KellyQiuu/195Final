package app.UsecaseFactory;

import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectOutputBoundary;
import use_case.connect.ConnectInputBoundary;
import view.ConnectView;

public class ConnectUseCaseFactory {

    private ConnectUseCaseFactory() {}
    public static ConnectView create(ConnectController connectController) {
        return new ConnectView(connectController);
    }

    public static ConnectController createUserConnectUseCase(
            ConnectViewModel connectViewModel,
            ConnectDataAccessInterface connectDataAccessInterface
    ) {
        ConnectOutputBoundary presenter = new ConnectPresenter(connectViewModel);
        ConnectInputBoundary interactor = new ConnectInteractor(presenter, connectDataAccessInterface);

        return new ConnectController(interactor);
    }
}
