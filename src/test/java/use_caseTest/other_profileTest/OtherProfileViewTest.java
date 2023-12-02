package use_caseTest.other_profileTest;

import app.UsecaseFactory.OtherProfileUseCaseFactory;
import app.UsecaseFactory.UserListUseCaseFactory;
import data_access.UserDataAccessObject;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.other_profile.OtherProfileState;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.self_profile.SelfProfileViewModel;
import interface_adapter.user_list.UserListState;
import org.junit.Before;
import org.junit.Test;
import use_case.connect.ConnectDataAccessInterface;
import use_case.other_profile.OtherProfileDataAccessInterface;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.user_list.UserListDataAccessInterface;
import view.OtherProfileView;
import view.UserListView;
import view.UserListViewModel;
import javax.swing.JTextField;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OtherProfileViewTest {
	String senderUsername = "FakeKelly"; // Replace with actual username
	String recipientEmail = "qiuwenyu2021@outlook.com"; // Replace with actual recipient email
	String recipientUsername = "FakeKelly";

	private static class StubProfileViewModel {
		private String userName = "TestUser";
		private String userEmail = "test@example.com";
		private List<String> userCourses = Arrays.asList("Course1", "Course2");

		public OtherProfileState getState() {
			return new OtherProfileState();
		}
	}

	@Before
	public void setUp() {

	}


	@Test
	public void TestOtherProfileView() {
		try {
			ViewManagerModel viewManagerModel = new ViewManagerModel();
			OtherProfileViewModel otherProfileViewModel = new OtherProfileViewModel();
			OtherProfileDataAccessInterface otherProfileDataAccessObject;

			try {
				otherProfileDataAccessObject = new UserDataAccessObject();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Could not open user data file.");
				throw new RuntimeException(e);
			}
			UserListViewModel userListViewModel = new UserListViewModel();
			SelfProfileViewModel selfProfileViewModel = new SelfProfileViewModel();
			ConnectViewModel connectViewModel = new ConnectViewModel();
			ConnectDataAccessInterface connectDataAccessObject = new UserDataAccessObject();
			SelfProfileDataAccessInterface selfProfileDataAccessObject = new UserDataAccessObject();
			UserListDataAccessInterface userListDataAccessObject;
			try {
				userListDataAccessObject = new UserDataAccessObject();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Could not open user data file.");
				throw new RuntimeException(e);
			}
			UserListView userListView = UserListUseCaseFactory.create(
					viewManagerModel,
					userListViewModel,
					otherProfileViewModel,
					userListDataAccessObject,
					otherProfileDataAccessObject,
					selfProfileViewModel,
					selfProfileDataAccessObject
			);
			assert userListView != null;
			viewManagerModel.setActiveView(userListView.getViewName());
			assertNull(viewManagerModel.getPreviousView());

			OtherProfileView otherProfileView = OtherProfileUseCaseFactory.create(viewManagerModel,
					otherProfileViewModel,
					otherProfileDataAccessObject,
					connectViewModel,
					connectDataAccessObject);

			assert otherProfileView != null;

			otherProfileView.actionPerformed(new ActionEvent(otherProfileView, 1, "test"));
			viewManagerModel.setActiveView(otherProfileView.getViewName());
			otherProfileView.goBack();

			assert true;
		} catch (Exception e) {
			assert false;
		}
	}

	@Test
	public void testPropertyChangeUpdatesFields() {
		// Simulate the property change event
	}
}
