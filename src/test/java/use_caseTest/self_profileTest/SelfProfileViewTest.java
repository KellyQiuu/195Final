package use_caseTest.self_profileTest;

import data_access.PSQLDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfilePresenter;
import interface_adapter.self_profile.SelfProfileViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.self_profile.SelfProfileDataAccessInterface;
import use_case.self_profile.SelfProfileInputBoundary;
import use_case.self_profile.SelfProfileInteractor;
import use_case.self_profile.SelfProfileOutputBoundary;
import view.SelfProfileView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SelfProfileViewTest {
	@Before
	public void setUp() {
	}
	@Test
	public void TestSelfProfileView(){
		try {
			ViewManagerModel viewManagerModel = new ViewManagerModel();
			SelfProfileViewModel selfProfileViewModel = new SelfProfileViewModel();
			SelfProfileDataAccessInterface selfProfileDataAccessObject;

			try {
				selfProfileDataAccessObject = new PSQLDataAccessObject();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Could not open user data file.");
				throw new RuntimeException(e);
			}
			SelfProfileOutputBoundary presenter = new SelfProfilePresenter(selfProfileViewModel, viewManagerModel);
			SelfProfileInputBoundary interactor = new SelfProfileInteractor(selfProfileDataAccessObject, presenter);
			SelfProfileController selfProfileController = new SelfProfileController(interactor);
			SelfProfileView selfProfileView = new SelfProfileView(viewManagerModel,selfProfileViewModel, selfProfileController);
			selfProfileView.actionPerformed(new ActionEvent(selfProfileView, 1, "test"));


			assert true;
		} catch (Exception e) {
			assert false;
		}
	}
}
