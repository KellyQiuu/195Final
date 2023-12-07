package dataAccessTest;

import static org.junit.Assert.*;
import data_access.PSQLDataAccessObject;
import entity.GeneralUser;
import entity.User;
import entity.UserFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataAcessTest {

    private PSQLDataAccessObject userDataAccessObject;
    private User testUser;

    @Before
    public void setUp() throws IOException {
        // Assuming UserFactory and User classes are properly defined
        userDataAccessObject = new PSQLDataAccessObject();
        testUser = UserFactory.createUser("testUser", "password", "test@email.com", "12345", new ArrayList<>(Arrays.asList("Course1", "Course2")));
    }

    @Test
    public void testSaveAndGetUser() throws IOException {
        userDataAccessObject.save(testUser);
        GeneralUser retrievedUser = userDataAccessObject.get("testUser");
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
