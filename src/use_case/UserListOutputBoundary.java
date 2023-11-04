package use_case;
import use_case.UserListOutputData;

public interface UserListOutputBoundary {
    void prepareSuccessView(UserListOutputData clear);
}
