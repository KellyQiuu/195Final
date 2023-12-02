package use_caseTest.connectTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import interface_adapter.connect.*;
import use_case.connect.*;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ConnectTest {

    private ConnectController connectController;
    private ConnectViewModel connectViewModel;
    private ConnectPresenter connectPresenter;
    private ConnectInteractor connectInteractor;
    private ConnectState connectState;
    private TestConnectDataAccessInterface dataAccess;

    private static class TestConnectDataAccessInterface implements ConnectDataAccessInterface {
        boolean userFound = true;

        @Override
        public User get(String username) throws IOException {
            if (userFound) {
                return new User("FakeUser", "password123", "1", "fakeuser@example.com", new ArrayList<>(Arrays.asList("Course1", "Course2")));
            } else {
                throw new IOException("User not found.");
            }
        }
    }

    @Before
    public void setUp() {
        connectViewModel = new ConnectViewModel();
        connectPresenter = new ConnectPresenter(connectViewModel);
        dataAccess = new TestConnectDataAccessInterface();
        connectInteractor = new ConnectInteractor(connectPresenter, dataAccess);
        connectState = new ConnectState();
        connectController = new ConnectController(connectInteractor);
    }

    @Test
    public void testConnectionProcess() throws Exception {
        connectState.setConnectionInProgress(true);
        connectController.initiateConnectionProcess("recipient@example.com");

        Assert.assertTrue(connectState.isConnectionInProgress());

        connectController.handleSendEmailClicked("Test message");
        Assert.assertFalse(connectState.isConnectionInProgress());
        Assert.assertEquals("Email sent successfully.", connectViewModel.getConnectionStatus());

        dataAccess.userFound = false;
        connectState.setConnectionInProgress(false);
        connectController.initiateConnectionProcess("recipient@example.com");
        try {
            connectController.handleSendEmailClicked("Test message");
        } catch(IOException e) {
            Assert.assertEquals("User not found.", e.getMessage());
        }
        Assert.assertFalse(connectState.isConnectionInProgress());
        Assert.assertTrue(connectViewModel.getConnectionStatus().contains("Failed to connect"));
    }

    // Additional tests can be added here to cover more scenarios.
}
