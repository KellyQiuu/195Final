package interface_adapter.connect;

import use_case.connect.ConnectOutputBoundary;
import use_case.connect.ConnectOutputData;

public class ConnectPresenter implements ConnectOutputBoundary {
    private final ConnectViewModel viewModel;

    public ConnectPresenter(ConnectViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onConnectionResult(ConnectOutputData outputData) {
        if (outputData.isSuccess()) {
            viewModel.setConnectionStatus("Email sent successfully.");
        } else {
            viewModel.setConnectionStatus("Failed to connect: " + outputData.getMessage());
        }
    }
}
