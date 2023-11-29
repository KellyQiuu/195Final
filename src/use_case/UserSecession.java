package use_case;

import use_case.user_list.UserSecessionInterface;

public class UserSecession implements UserSecessionInterface {
    // this is a sigleton class defined to shared data such as current user between different usecase
    private static UserSecession instance;
    private String currentUserName;

    private UserSecession() {}

    public static UserSecession getInstance() {
        if (instance == null) {
            instance = new UserSecession();
        }
        return instance;
    }

    public void setCurrentUserName(String userName) {
        System.out.println("(UserSecession): set current UserName is set, :"+userName);
        this.currentUserName = userName;
    }

    public String getCurrentUserName() {
        System.out.println("(UserSecession): get current User Name is called, "+currentUserName);
        return currentUserName;

    }
}
