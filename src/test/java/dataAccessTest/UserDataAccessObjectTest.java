package dataAccessTest;


import data_access.UserDataAccessObject;
import entity.GeneralUser;
import entity.GeneralUserFactory;

import data_access.PSQLDataAccessObject;

import entity.User;
import entity.UserFactory;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDataAccessObjectTest {

	private PSQLDataAccessObject userDataAccessObject;
	private final String testFilePath = "test_users.csv";
	private GeneralUser testUser;

	@Before
	public void setUp() throws IOException {
		// Set up a test file path and create a user for testing

		userDataAccessObject = new PSQLDataAccessObject() {

		};

		// Create a test user with some data
		testUser = new User("testUser", "password", "test@example.com", "1", new ArrayList<String>());
		// Assume UserFactory.createUser is a static method that creates a User object.
		GeneralUserFactory.createUser("testUser", "password", "test@example.com", "1", new ArrayList<String>());

		// Write the test user to the test file
		List<String> lines = new ArrayList<>();
		lines.add("testUser,password,test@example.com,1,");
		Files.write(Paths.get(testFilePath), lines);
	}

	@Test
	public void testLoadUsersFromFile() throws IOException {
		// TODO: Modify this method to be testable. [NOV.23]
		//userDataAccessObject.loadUsersFromFile(testFilePath);
		// Test that the user data was loaded correctly.
		GeneralUser loadedUser = userDataAccessObject.get("testUser");
		assertNotNull(loadedUser);
		assertEquals("testUser", loadedUser.getName());
	}

	@Test
	public void testCheckValidUsername() {
		// Assuming "testUser" is already in the usersDataMap after the setUp
		assertFalse(userDataAccessObject.checkValidUsername("testUser"));
		// Assuming "newUser" is not in the usersDataMap
		assertTrue(userDataAccessObject.checkValidUsername("newUser"));
	}

	@Test
	public void testExistsByName() {
		// Assuming "testUser" is already in the usersDataMap after the setUp
		assertTrue(userDataAccessObject.existsByName("testUser"));
		// Assuming "nonExistingUser" is not in the usersDataMap
		assertFalse(userDataAccessObject.existsByName("nonExistingUser"));
	}

	@Test
	public void testSave() throws IOException {
		GeneralUser newUser = new User("newUser", "newPass", "new@example.com", "2", new ArrayList<String>());
		userDataAccessObject.save(newUser);
		assertTrue(userDataAccessObject.existsByName("newUser"));
	}

	// ... Additional tests for other methods ...

	@After
	public void tearDown() throws IOException {
		// Delete the test file after the tests are done.
		Files.deleteIfExists(Paths.get(testFilePath));
	}
}

