package use_caseTest.signupTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.signup.*;
import view.signup_login.SignupView;

import java.io.IOException;
import java.util.ArrayList;

public class SignupTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testSignup(){
        // Creat a test data
        String validEmail = "cyguchi@gmail.com";
        String invalidEmail = "iNVALID";
        String generalpassword = "1111";

        String name1 = "Aha";

        ArrayList<String> courses = new ArrayList<>();
        courses.add("MAT301");
        courses.add("MAT334");
        courses.add("MAT346");
        courses.add("MAT301");
        courses.add("MAT301");

        ArrayList<String> courses2 = new ArrayList<>();
        courses.add("Mat337");
        courses.add("APM346");

        // test get method in SignupInputData.
        //case1: valid name and email
        SignupInputData case1 = new SignupInputData(name1, generalpassword, "id", validEmail, courses);
        assertEquals(name1, case1.getUsername());
        assertEquals(generalpassword, case1.getPassword());
        assertEquals("id", case1.getId());
        assertEquals(validEmail, case1.getEmail());
        assertEquals(courses, case1.getCourses());

        //case2: invalid name and valid email
        SignupInputData case2 = new SignupInputData(name1, generalpassword, "id", invalidEmail, courses);
        assertEquals(name1, case2.getUsername());
        assertEquals(generalpassword, case2.getPassword());
        assertEquals("id", case2.getId());
        assertEquals(invalidEmail, case2.getEmail());
        assertEquals(courses, case2.getCourses());

        //case3: empty course string work correctly.
        ArrayList<String> emptry_courses = new ArrayList<>();
        SignupInputData case3 = new SignupInputData(name1, generalpassword, "id", validEmail, emptry_courses);
        assertEquals(emptry_courses, case3.getCourses());

        //case4
        SignupInputData case4 = new SignupInputData(name1, generalpassword, "id", validEmail, courses2);

        //test SignupOutputData
        String name2 = "Name";
        boolean suc = true;
        boolean fail = false;

        //test successful case
        SignupOutputData case5 = new SignupOutputData(name2, suc);
        assertEquals(name2, case5.getUsername());
        assertEquals(suc, case5.isSuccessful());

        //test fail case
        SignupOutputData case6 =new SignupOutputData(name2, fail);
        assertEquals(fail, case6.isSuccessful());
    }



}
