package entityTest;

import entity.User;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
	private User user;
	private String name;
	private String password;
	private String id;
	private String email;
	private ArrayList<String> courses;

	@Before
	public void setUp() {
		name = "JohnDoe";
		password = "password123";
		id = "1";
		email = "johndoe@example.com";
		courses = new ArrayList<>();
		courses.add("Course1");
		courses.add("Course2");

		user = new User(name, password, id, email, courses);
	}

	@Test
	public void testGetName() {
		assertEquals(name, user.getName());
	}

	@Test
	public void testGetPassword() {
		assertEquals(password, user.getPassword());
	}

	@Test
	public void testGetId() {
		assertEquals(id, user.getId());
	}

	@Test
	public void testGetEmail() {
		assertEquals(email, user.getEmail());
	}

	@Test
	public void testGetCourses() {
		List<String> retrievedCourses = user.getCourses();
		assertNotNull(retrievedCourses);
		assertEquals(courses.size(), retrievedCourses.size());
		for (int i = 0; i < courses.size(); i++) {
			assertEquals(courses.get(i), retrievedCourses.get(i));
		}
	}

	@Test
	public void testGetCoursesString() {
		String expectedCoursesString = "Course1+Course2";
		assertEquals(expectedCoursesString, user.getCoursesString());
	}

	@Test
	public void testToString() {
		String expectedString = "JohnDoe,password123,1,johndoe@example.com,Course1+Course2";
		assertEquals(expectedString, user.toString());
	}
}
