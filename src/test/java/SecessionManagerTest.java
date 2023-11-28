import java.util.ArrayList;

import use_case.SessionManagerInteractor;
import entity.User;
import entity.UserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecessionManagerTest {
    //testing the secession manager.

    private SessionManagerInteractor sessionManager;
    private User testUser;

    @Before
    public void setUp() {
        // Set up your test environment before each test
        sessionManager = new SessionManagerInteractor();
        testUser = UserFactory.createUser("Lynnesy", "wenyu.qiu@mail.utoronto.ca", "0",
                "wenyu.qiu@mail.utoronto.ca", new ArrayList<String>());
    }

    @Test
    public void testLogin() {
        // Simulate login
        sessionManager.createUserSession(testUser);

        // Retrieve the current user
        User currentUser = sessionManager.getCurrentUser();

        // Assert that the current user is not null, meaning a user is logged in
        Assert.assertNotNull("User should be logged in", currentUser);

        // Assert that the current user's ID matches the expected ID
        Assert.assertEquals("User ID should match", testUser.getId(), currentUser.getId());

        // Optionally, you could also check other user details like email, name, etc.
        Assert.assertEquals("Email should match", testUser.getEmail(), currentUser.getEmail());
    }

    @Test
    public void testLogout() {
        // Simulate login
        sessionManager.createUserSession(testUser);

        // Simulate logout
        sessionManager.endUserSession();

        // Attempt to retrieve the current user after logout
        User currentUser = sessionManager.getCurrentUser();

        // Assert that the current user is null, meaning no user should be logged in
        Assert.assertNull("User should be logged out", currentUser);
    }


}












