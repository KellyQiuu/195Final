package use_caseTest.user_listTest;

import entity.User;
import entity.UserFactory;
import interface_adapter.user_list.UserListController;
import interface_adapter.user_list.UserListState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.user_list.UserListInputBoundary;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class UserListControllerTest{

    @Mock
    private UserListInputBoundary mockUserListInteractor;

    private UserListController userListController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userListController = new UserListController(mockUserListInteractor);
    }

    @Test
    void executeCallsUserListInteractor() throws IOException {
        userListController.execute();
        verify(mockUserListInteractor).execute();
    }
    @Test
    void userListStateManagesUsers() {
        UserListState state = new UserListState();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CSC207");
        courses.add("CSC07");
        courses.add("CSC7");
        courses.add("CSC27");
        courses.add("CS7");
        users.add(new User("Kelly","1","12","123",courses));
        state.setUsers(users);

        assertEquals(1, state.getUsers().size(), "User list should contain one user");
    }

    @Test
    void userListStateManagesUsername() {
        UserListState state = new UserListState();
        state.setUsername("Kelly");
        ArrayList<String> courses = new ArrayList<>();
        courses.add("CSC207");
        courses.add("CSC07");
        courses.add("CSC7");
        courses.add("CSC27");
        courses.add("CS7");

        User u = UserFactory.createUser("Kelly","1","12","123",courses);
        ArrayList<User> all = new ArrayList<>();
        all.add(u);

        state.setUsers(all);


    }
}
