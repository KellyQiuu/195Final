package use_caseTest.other_profileTest;

import app.UsecaseFactory.OtherProfileUseCaseFactory;
import data_access.UserDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectViewModel;
import interface_adapter.other_profile.OtherProfileViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.connect.ConnectDataAccessInterface;
import use_case.other_profile.OtherProfileDataAccessInterface;
import view.OtherProfileView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import static org.junit.Assert.assertNull;

public class OtherProfileViewTest {
	@Before
	public void setUp() {
	}
	@Test
	public void TestOtherProfileView(){
		try {
			ViewManagerModel viewManagerModel = new ViewManagerModel();
			OtherProfileViewModel otherProfileViewModel = new OtherProfileViewModel();
			OtherProfileDataAccessInterface otherProfileDataAccessObject;

			try {
				otherProfileDataAccessObject = new UserDataAccessObject(new UserFactory());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Could not open user data file.");
				throw new RuntimeException(e);
			}

			ConnectViewModel connectViewModel = new ConnectViewModel();
			ConnectDataAccessInterface connectDataAccessObject = new UserDataAccessObject(new UserFactory());

			OtherProfileView otherProfileView1 = OtherProfileUseCaseFactory.create(viewManagerModel,
					otherProfileViewModel,
					otherProfileDataAccessObject,
					connectViewModel,
					connectDataAccessObject);

			assert otherProfileView1 != null;
			viewManagerModel.setActiveView(otherProfileView1.getName());
			assertNull(viewManagerModel.getPreviousView());

			OtherProfileView otherProfileView = OtherProfileUseCaseFactory.create(viewManagerModel,
					otherProfileViewModel,
					otherProfileDataAccessObject,
					connectViewModel,
					connectDataAccessObject);

			assert otherProfileView != null;

			otherProfileView.actionPerformed(new ActionEvent(otherProfileView, 1, "test"));

			otherProfileView.goBack();

			assert true;
		} catch (Exception e) {
			assert false;
		}
	}
}
