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
        String statusMessage = outputData.isSuccess() ? "Email sent successfully."
                : "Failed to connect: " + getValidMessage(outputData.getMessage());
        viewModel.setConnectionStatus(statusMessage);
    }

    private String getValidMessage(String message) {
        return (message == null || message.trim().isEmpty()) ? "An unknown error occurred." : message;
    }
}
