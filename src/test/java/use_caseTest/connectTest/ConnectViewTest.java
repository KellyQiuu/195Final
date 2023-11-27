package use_caseTest.connectTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import view.ConnectView;
import interface_adapter.connect.ConnectController;
import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInputData;

import javax.swing.*;
import java.awt.*;

public class ConnectViewTest {

    private ConnectView connectView;
    private TestConnectController testController;

    private static class TestConnectController extends ConnectController {
        String capturedMessage;
        boolean sendClicked = false;

        public TestConnectController(ConnectInputBoundary inputBoundary) {
            super(inputBoundary);
        }

        @Override
        public void handleSendEmailClicked(String message) {
            capturedMessage = message;
            sendClicked = true;
        }
    }

    @Before
    public void setUp() {
        // Initialize ConnectView with the test controller
        testController = new TestConnectController(null); // Passing null because we'll not invoke the real method
        connectView = new ConnectView(testController);
    }

    @Test
    public void testSendButtonActionListener() {
        // Find the message text area and the send button
        JTextArea messageTextArea = findComponent(connectView, JTextArea.class);
        JButton sendButton = findComponent(connectView, JButton.class);

        // Set a message and simulate a button click
        messageTextArea.setText("Test message");
        sendButton.doClick();

        // Assert that the handleSendEmailClicked method was called with the correct message
        Assert.assertTrue("Send button click did not trigger expected behavior", testController.sendClicked);
        Assert.assertEquals("Test message", testController.capturedMessage);
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
