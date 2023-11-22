package app;

import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.connect.ConnectController;
import use_case.connect.ConnectInteractor;
import interface_adapter.connect.ConnectPresenter;
import interface_adapter.connect.ConnectViewModel;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectOutputBoundary;

import java.io.IOException;

public class ConnectUseCaseFactory {

    private ConnectUseCaseFactory() {}

    public static ConnectController create(ConnectViewModel viewModel, String recipientemail) throws IOException {
        ConnectDataAccessInterface userDataAccess = new UserDataAccessObject(new UserFactory());

        ConnectOutputBoundary presenter = new ConnectPresenter(viewModel);

        ConnectInteractor interactor = new ConnectInteractor(presenter, userDataAccess);

        //TODO: Need to get recipient email here.
        return new ConnectController(interactor, recipientemail);
    }
}
