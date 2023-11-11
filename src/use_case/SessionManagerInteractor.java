package use_case;
import entity.User;

import java.util.HashMap;
import java.util.Map;

public class SessionManagerInteractor {
    private Map<String, User> userSessions = new HashMap<>();
    private String currentUserSessionId;

    public void createUserSession(User user) {
        String sessionId = "local_session_id";
        userSessions.put(sessionId, user);
        currentUserSessionId = sessionId;
    }

    public User getCurrentUser() {
        return userSessions.get(currentUserSessionId);
    }

    public void endUserSession() {
        if (currentUserSessionId != null) {
            userSessions.remove(currentUserSessionId);
            currentUserSessionId = null;
        }
    }
}
