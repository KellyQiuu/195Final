package use_case;

public class UserSecession {
    // this is a sigleton class defined to shared data such as current user between different usecase
    private static UserSecession instance = new UserSecession();
    private String currentUserName;

    private UserSecession() {}

    public static UserSecession getInstance() {
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
