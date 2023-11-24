package use_caseTest.other_profileTest;

import data_access.UserDataAccessObject;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfilePresenter;
import interface_adapter.other_profile.OtherProfileState;
import interface_adapter.other_profile.OtherProfileViewModel;
import use_case.other_profile.*;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OtherProfileTest {
    @Before
    public void setUp() {
    }

    @Test
    public void testOtherProfile() throws IOException {
        // Create a test user
        ArrayList<String> courses = new ArrayList<>();
        courses.add("STA130");
        courses.add("STA347");
        courses.add("STA457");
        courses.add("STA400");
        courses.add("STA365");

        User testUser = new UserDataAccessObject(new UserFactory()).getUser("testuser");

        assertNotNull(testUser);
        assertEquals("testuser",testUser.getName());
        assertEquals("123456", testUser.getPassword());
        assertEquals("123", testUser.getId());
        assertEquals("123@gmail.com", testUser.getEmail());
        assertEquals(courses, testUser.getCourses());

        try {
            CardLayout cardLayout = new CardLayout();
            JPanel views = new JPanel(cardLayout);
            ViewManagerModel viewManagerModel = new ViewManagerModel();
            new ViewManager(views, cardLayout, viewManagerModel);
            OtherProfileViewModel otherProfileViewModel = new OtherProfileViewModel();

            OtherProfileOutputBoundary presenter = new OtherProfilePresenter(otherProfileViewModel, viewManagerModel);

            OtherProfileInputData inputData = new OtherProfileInputData(testUser.getName());

            OtherProfileInputBoundary interactor = new OtherProfileInteractor(new UserDataAccessObject(new UserFactory()),
                    presenter);

            OtherProfileController controller = new OtherProfileController(interactor);
            controller.execute(inputData.getUsername());
            OtherProfileOutputData outputData = new OtherProfileOutputData(testUser);
            presenter.prepareSuccessView(outputData);

            OtherProfileState otherProfileState = new OtherProfileState();
            otherProfileState.setUserCourses(testUser.getCourses());
            otherProfileState.setUserName(testUser.getName());
            otherProfileState.setUserEmail(testUser.getEmail());
            OtherProfileState otherProfileState1 = new OtherProfileState(otherProfileState);
            assertEquals("testuser", otherProfileState1.getUserName());
            assertEquals("123@gmail.com", otherProfileState1.getUserEmail());
            assertEquals(courses, otherProfileState1.getUserCourses());

            assertEquals(testUser, otherProfileViewModel.getUser());
            otherProfileViewModel.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {

                }
            });

            assert true;
        } catch (Exception e) {
            assert false;
        }

    }
}
