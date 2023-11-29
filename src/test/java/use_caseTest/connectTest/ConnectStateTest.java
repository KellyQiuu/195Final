package use_caseTest.connectTest;

import interface_adapter.connect.ConnectState;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectStateTest {

    @Before
    public void setUp(){
    }

    @Test
    public void testConnectState() {
        // Initialize test inputs.
        String status = "";
        String newStatus = "new";
        boolean fail = false;
        boolean sec = true;

        ConnectState connectState = new ConnectState();

        // test get method in ConnectState
        assertEquals(status, connectState.getConnectionStatus());

        // test set method in ConnectState
        connectState.setConnectionStatus(newStatus);
        assertEquals(newStatus, connectState.getConnectionStatus());

        // test connection in progress
        assertEquals(fail, connectState.isConnectionInProgress());
        connectState.setConnectionInProgress(sec);
        assertEquals(sec, connectState.isConnectionInProgress());
    }


}
