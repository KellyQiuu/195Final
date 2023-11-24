package entityTest;

import entity.User;
import entity.UserFactory;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class UserFactoryTest {

	@Test
	public void testCreateUser() {
		// Arrange
		String username = "testUser";
		String password = "testPass";
		String id = "12345";
		String email = "test@example.com";
		ArrayList<String> courses = new ArrayList<>(Arrays.asList("Algebra", "Biology"));

		// Act
		User user = UserFactory.createUser(username, password, id, email, courses);

		// Assert
		assertNotNull("The user should not be null", user);
		assertEquals("Username should match the input", username, user.getName());
		assertEquals("Password should match the input", password, user.getPassword());
		assertEquals("ID should match the input", id, user.getId());
		assertEquals("Email should match the input", email, user.getEmail());
		assertEquals("Courses should match the input", courses, user.getCourses());
	}

	@Test
	public void testCreateUserWithEmptyCourses() {
		// Arrange
		String username = "emptyCoursesUser";
		String password = "pass";
		String id = "67890";
		String email = "empty@example.com";
		ArrayList<String> courses = new ArrayList<>();

		// Act
		User user = UserFactory.createUser(username, password, id, email, courses);

		// Assert
		assertNotNull("The user should not be null even with empty courses", user);
		assertTrue("Courses should be empty", user.getCourses().isEmpty());
	}

	@Test
	public void testCreateUserWithLongStrings() {
		String longString = new String(new char[1000]).replace('\0', 'a');
		ArrayList<String> longCourses = new ArrayList<>(Arrays.asList(longString, longString));

		User user = UserFactory.createUser(longString, longString, longString, longString, longCourses);

		assertNotNull(user);
		assertEquals(longString, user.getName());
		assertEquals(longString, user.getPassword());
		assertEquals(longString, user.getId());
		assertEquals(longString, user.getEmail());
		assertEquals(longCourses, user.getCourses());
	}

	@Test
	public void testCreateUserWithSpecialCharacters() {
		String specialCharString = "!@#$%^&*()";
		ArrayList<String> specialCharCourses = new ArrayList<>(Arrays.asList("Art&Craft", "Science*Experiment"));

		User user = UserFactory.createUser(specialCharString, specialCharString, specialCharString, specialCharString, specialCharCourses);

		assertNotNull(user);
		assertEquals(specialCharString, user.getName());
		assertEquals(specialCharString, user.getPassword());
		assertEquals(specialCharString, user.getId());
		assertEquals(specialCharString, user.getEmail());
		assertEquals(specialCharCourses, user.getCourses());
	}
}
