package use_caseTest.self_profileTest;

import data_access.PSQLDataAccessObject;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfilePresenter;
import interface_adapter.self_profile.SelfProfileState;
import interface_adapter.self_profile.SelfProfileViewModel;
import org.junit.Before;
import org.junit.Test;

import use_case.self_profile.*;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SelfProfileTest {
	@Before
	public void setUp() {
	}
	@Test
	public void testSelfProfile() throws IOException {
		// Create a test user
		ArrayList<String> courses = new ArrayList<>();
		courses.add("STA130");
		courses.add("STA347");
		courses.add("STA457");
		courses.add("STA400");
		courses.add("STA365");

		User testUser = new PSQLDataAccessObject().getUser("testuser");

		assertNotNull(testUser);
		assertEquals("testuser",testUser.getName());
		assertEquals("123456", testUser.getPassword());
		assertEquals("123", testUser.getId());
		assertEquals("123@gmail.com", testUser.getEmail());
		assertEquals(courses, testUser.getCourses());
		assertEquals("123456", testUser.getPassword());

		try {
			CardLayout cardLayout = new CardLayout();
			JPanel views = new JPanel(cardLayout);
			ViewManagerModel viewManagerModel = new ViewManagerModel();
			new ViewManager(views, cardLayout, viewManagerModel);
			SelfProfileViewModel selfProfileViewModel = new SelfProfileViewModel();

			SelfProfileOutputBoundary presenter = new SelfProfilePresenter(selfProfileViewModel, viewManagerModel);

			SelfProfileInputData inputData = new SelfProfileInputData(testUser.getName());

			SelfProfileInputBoundary interactor = new SelfProfileInteractor(new PSQLDataAccessObject(),
					presenter);

			SelfProfileController controller = new SelfProfileController(interactor);
			controller.execute(testUser.getName());
			SelfProfileOutputData outputData = new SelfProfileOutputData(testUser);
			presenter.prepareSuccessView(outputData);

			SelfProfileState SelfProfileState = new SelfProfileState();
			SelfProfileState.setUserCourses(testUser.getCourses());
			SelfProfileState.setUserName(testUser.getName());
			SelfProfileState.setUserEmail(testUser.getEmail());
			SelfProfileState SelfProfileState1 = new SelfProfileState(SelfProfileState);
			assertEquals("testuser", SelfProfileState1.getUserName());
			assertEquals(testUser, selfProfileViewModel.getUser());
			assertEquals("123@gmail.com", SelfProfileState1.getUserEmail());
			assertEquals(courses, SelfProfileState1.getUserCourses());

			selfProfileViewModel.addPropertyChangeListener(new PropertyChangeListener() {
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
