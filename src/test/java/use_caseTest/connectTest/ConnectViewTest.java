package use_caseTest.connectTest;

import entity.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import view.ConnectView;
import interface_adapter.connect.ConnectController;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.connect.ConnectPresenter;
import use_case.connect.ConnectInteractor;
import use_case.connect.ConnectDataAccessInterface;
import use_case.connect.ConnectOutputData;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ConnectViewTest {

    private ConnectView connectView;
    private ConnectController connectController;
    private ConnectViewModel connectViewModel;
    private ConnectInteractor connectInteractor;
    private ConnectDataAccessInterface connectDataAccessInterface;
    private boolean emailSent = false;

    @Before
    public void setUp() {
        connectViewModel = new ConnectViewModel();
        connectDataAccessInterface = new ConnectDataAccessInterface() {
            @Override
            public User get(String username) throws IOException {
                // Return a stub user for testing
                return new User("FakeUser", "password123", "1", "fakeuser@example.com",
                        new ArrayList<String>(Arrays.asList("Course1", "Course2")));

            }
        };

        // Mock the presenter to capture the connection result
        ConnectPresenter connectPresenter = new ConnectPresenter(connectViewModel) {
            @Override
            public void onConnectionResult(ConnectOutputData outputData) {
                super.onConnectionResult(outputData);
                emailSent = outputData.isSuccess();
            }
        };

        connectInteractor = new ConnectInteractor(connectPresenter, connectDataAccessInterface);
        connectController = new ConnectController(connectInteractor);
        connectView = new ConnectView(connectController);
    }

    @Test
    public void testSendButtonActionListener() {
        // Find the message text area and the send button
        JTextArea messageTextArea = findComponent(connectView, JTextArea.class);
        JButton sendButton = findComponent(connectView, JButton.class);

        // Test sending a message
        messageTextArea.setText("Test message");
        sendButton.doClick();

        // Assert that the message was set and emailSent flag is true
        assertEquals("Test message", messageTextArea.getText());
        assertTrue(emailSent);

        // Test sending an empty message
        messageTextArea.setText("");
        sendButton.doClick();

        // Assert the message is empty and emailSent flag is still true (no change)
        assertEquals("", messageTextArea.getText());
        assertTrue(emailSent);
    }

    private <T extends Component> T findComponent(Container container, Class<T> componentClass) {
        for (Component comp : container.getComponents()) {
            if (componentClass.isInstance(comp)) {
                return componentClass.cast(comp);
            } else if (comp instanceof Container) {
                T child = findComponent((Container) comp, componentClass);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }
}
