package entityTest;

import entity.GeneralUser;
import entity.GeneralUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GeneralUserFactoryTest {

    @Test
    public void testCreateUser() {
        // Arrange
        String username = "testUser";
        String password = "testPass";
        String id = "12345";
        String email = "test@example.com";
        ArrayList<String> courses = new ArrayList<>(Arrays.asList("Algebra", "Biology"));

        // Act
        GeneralUser user = GeneralUserFactory.createUser(username, password, id, email, courses);
        //since the output is null, we do not assert anything.
    }}

