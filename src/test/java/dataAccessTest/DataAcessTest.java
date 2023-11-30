package dataAccessTest;

import static org.junit.Assert.*;

import data_access.UserDataAccessObject;
import entity.User;
import entity.UserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class DataAcessTest {

    private UserDataAccessObject userDataAccessObject;
    private User testUser;

    @Before
    public void setUp() throws IOException {
        // Assuming UserFactory and User classes are properly defined
        UserFactory userFactory = new UserFactory();
        userDataAccessObject = new UserDataAccessObject(userFactory);
        testUser = UserFactory.createUser("testUser", "password", "test@email.com", "12345", new ArrayList<>(Arrays.asList("Course1", "Course2")));
    }

    @Test
    public void testSaveAndGetUser() throws IOException {
        userDataAccessObject.save(testUser);
        User retrievedUser = userDataAccessObject.get("testUser");
        assertNotNull(retrievedUser);
        assertEquals("testUser", retrievedUser.getName());
    }

    @Test
    public void testCheckValidUsername() {
        boolean isValid = userDataAccessObject.checkValidUsername("newUser");
        assertTrue(isValid);
        isValid = userDataAccessObject.checkValidUsername("testUser");
        assertFalse(isValid);
    }

    // Additional tests can be added here for more coverage

    @After
    public void tearDown() throws IOException {
        // Cleanup the test data from users.csv to maintain test isolation
        // Be cautious with this in a real environment to not delete actual data
        //String content = new String(Files.readAllBytes(Paths.get(userDataAccessObject.filePath)));
        //content = content.replace("testUser,password,test@email.com,12345,Course1+Course2\n", "");

    }
}
