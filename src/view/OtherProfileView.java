package view;

import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.self_profile.SelfProfileController;
import interface_adapter.self_profile.SelfProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OtherProfileView extends JPanel implements ActionListener, PropertyChangeListener {
	public final String viewName = "other_profile";


	private final OtherProfileViewModel profileViewModel;
	private final OtherProfileController profileController;

	private JLabel nameLabel, emailLabel, coursesLabel, passwordLabel;
	private JTextField nameField, emailField, coursesField, passwordField;


	public OtherProfileView(OtherProfileViewModel profileViewModel, OtherProfileController profileController) {
		this.profileController = profileController;
		this.profileViewModel = profileViewModel;
		this.profileViewModel.addPropertyChangeListener(this);

		// Layout setup
		setLayout(new BorderLayout());
		add(createHeader(), BorderLayout.NORTH);
		add(createUserInfoPanel(), BorderLayout.CENTER);
	}

	private JPanel createHeader() {
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel header = new JLabel("User Information");
		header.setFont(new Font("Arial", Font.BOLD, 16));
		headerPanel.add(header);
		return headerPanel;
	}

	private JPanel createUserInfoPanel() {
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setLayout(new GridLayout(4, 2, 10, 10)); // Grid layout with 4 rows and 2 columns

		nameLabel = new JLabel("Name:");
		emailLabel = new JLabel("Email:");
		coursesLabel = new JLabel("Courses:");
		passwordLabel = new JLabel("Password:");

		nameField = new JTextField(profileViewModel.getUser().getName());
		emailField = new JTextField(profileViewModel.getUser().getEmail());
		coursesField = new JTextField(profileViewModel.getUser().getCourses().toString()); // Assuming getCourses() returns a List or similar
		passwordField = new JTextField(profileViewModel.getUser().getPassword());

		nameField.setEditable(false);
		emailField.setEditable(false);
		coursesField.setEditable(false);
		passwordField.setEditable(false);

		userInfoPanel.add(nameLabel);
		userInfoPanel.add(nameField);
		userInfoPanel.add(emailLabel);
		userInfoPanel.add(emailField);
		userInfoPanel.add(coursesLabel);
		userInfoPanel.add(coursesField);
		userInfoPanel.add(passwordLabel);
		userInfoPanel.add(passwordField);

		return userInfoPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}
}
