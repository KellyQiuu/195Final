package use_caseTest.connectTest;

import entity.User;
import use_case.UserSecession;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInputData;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectOutputBoundary;
import use_case.connect.ConnectOutputData;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectTest {

    private ConnectInteractor interactor;
    private FakeConnectOutputBoundary outputBoundary;
    private FakeConnectDataAccessInterface dataAccess;

    @Before
    public void setUp() {
        outputBoundary = new FakeConnectOutputBoundary();
        dataAccess = new FakeConnectDataAccessInterface();
        interactor = new ConnectInteractor(outputBoundary, dataAccess);
    }

    @Test
    public void testHandleConnect() throws Exception {
        String username = "testUser";
        String recipientEmail = "recipient@example.com";
        String message = "Hello, this is a test message.";

        // Assume the current user has been set somewhere in your application
        UserSecession.getInstance().setCurrentUserName(username);

        // Perform the connect operation
        ConnectInputData inputData = new ConnectInputData(message);
        interactor.handleConnect(inputData, recipientEmail);

        // Assert the expected results
        assertTrue(outputBoundary.isSuccessful);
        assertEquals("Email sent successfully.", outputBoundary.message);
    }

    private static class FakeConnectOutputBoundary implements ConnectOutputBoundary {
        boolean isSuccessful;
        String message;

        @Override
        public void onConnectionResult(ConnectOutputData outputData) {
            isSuccessful = outputData.isSuccess();
            message = outputData.getMessage();
        }
    }

    private static class FakeConnectDataAccessInterface implements ConnectDataAccessInterface {
        @Override
        public User get(String username) {
            // Return a fake user for testing purposes
            return new User(username, "password", "id", "email@example.com", null);
        }
    }
}
