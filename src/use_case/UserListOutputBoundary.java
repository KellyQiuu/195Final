package use_case;
import src.use_case.UserListOutputData;

public interface UserListOutputBoundary {
    void prepareSuccessView(UserListOutputData clear);
}
