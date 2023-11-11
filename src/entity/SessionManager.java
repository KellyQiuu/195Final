package entity;
import java.util.HashMap;
import java.util.Map;
public class SessionManager {
    // This map holds the user sessions. In a real-world scenario, this might be stored in a database or cache.
    private Map<String, User> userSessions = new HashMap<>();
    private String currentUserSessionId;

    // Method to create a new user session
    public void createUserSession(User user) {
        //TODO： Ye, use this function when you log in.

        String sessionId = "local_session_id";
        userSessions.put(sessionId, user); // Store the user object against the session ID
        currentUserSessionId = sessionId; // Set the current user session ID
    }

    // Method to get the current user
    public User getCurrentUser() {
        return userSessions.get(currentUserSessionId); // Retrieve the user associated with the current session ID
    }

    // Method to end a user session
    public void endUserSession() {
        if (currentUserSessionId != null) {
            userSessions.remove(currentUserSessionId); // Remove the user session from the storage
            currentUserSessionId = null; // Clear the current session ID
        }
    }
}
