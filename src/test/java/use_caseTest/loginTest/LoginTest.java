package use_caseTest.loginTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import use_case.login.LoginInputData;
import use_case.login.LoginOutputData;
import use_case.signup.*;
import view.signup_login.SignupView;

import java.io.IOException;
import java.util.ArrayList;

public class LoginTest {

    @Before
    public void setUp(){
    }

    @Test
    public void testLogin(){
        // Initialize test inputs.
        String username = "name";
        String password = "password";


        // test get method in LoginInputData
        LoginInputData case1 = new LoginInputData(username, password);
        assertEquals(username, case1.getUsername());
        assertEquals(password, case1.getPassword());


        // test get method in LoginOutputData
        boolean suc = true;
        boolean fail = true;

        //test successful case
        LoginOutputData loginOutputData1 = new LoginOutputData(username, suc);
        assertEquals(username, loginOutputData1.getUsername());
        assertEquals(suc, loginOutputData1.isSuccessful());

        //test fail case
        LoginOutputData loginOutputData2 = new LoginOutputData(username, fail);
        assertEquals(fail, loginOutputData1.isSuccessful());


    }


}
