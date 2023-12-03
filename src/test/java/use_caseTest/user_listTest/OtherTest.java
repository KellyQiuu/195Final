package use_caseTest.user_listTest;

import entity.User;
import interface_adapter.user_list.UserState;
import interface_adapter.user_list.UserViewModel;
import use_case.user_list.UserListOutputData;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class OtherTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testUserSate() {
        // Initialize test inputs.
        String username = "azhe";

        UserState userState = new UserState();


        // test get method in UserState
        assertEquals("", userState.getUsername());

        // test set method in ConnectState
        userState.setUsername(username);
        assertEquals(username, userState.getUsername());
    }

    @Test
    public void testUserViewModel() {
        // Initialize test inputs.
        String modelName = "name";

        UserViewModel userViewModel = new UserViewModel(modelName);

        // test get method in UserViewModel
        assertEquals(modelName, userViewModel.getName());

    }

    @Test
    public void testUserListOutputData() throws IOException {
        // Initialize test inputs.
        String username1 = "username1";
        String username2 = "username2";
        String password1 = "1";
        String password2 = "2";
        String e1 = "1";
        String e2 = "2";

        ArrayList<String> courses1 = new ArrayList<>();
        courses1.add("MAT301");
        courses1.add("STA347");
        courses1.add("MAT344");
        courses1.add("STA302");
        courses1.add("MAT334");

        ArrayList<String> courses2 = new ArrayList<>();
        courses2.add("Mat337");
        courses2.add("APM346");

        User user1 = new User(username1, password1, "id1", e1, courses1);
        User user2 = new User(username2, password2, "2", e2, courses2);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        UserListOutputData userListOutputData = new UserListOutputData(userList);

        // test the get method in UserListOutputData
        assertEquals(userList, userListOutputData.getUsers());

    }
}
