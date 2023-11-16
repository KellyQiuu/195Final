package view;

import interface_adapter.connect.ConnectController;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfileViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OtherProfileView extends JPanel implements ActionListener, PropertyChangeListener {
	public final String viewName = "other_profile";

	private final ConnectController connectController;
	private final OtherProfileViewModel profileViewModel;
	private final OtherProfileController profileController;

	private JLabel nameLabel, emailLabel, coursesLabel;
	private JTextField nameField, emailField, coursesField;
	private JButton connect;


	public OtherProfileView(OtherProfileViewModel profileViewModel, OtherProfileController profileController, ConnectController connectController) {
		this.profileController = profileController;
		this.profileViewModel = profileViewModel;
		this.connectController = connectController;
		this.profileViewModel.addPropertyChangeListener(this);

		// Layout setup
		setLayout(new BorderLayout());
		add(createHeader(), BorderLayout.NORTH);
		add(createUserInfoPanel(), BorderLayout.CENTER);
	}

	private JPanel createHeader() {
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel header = new JLabel("User " + profileViewModel.getUser().getName());
		header.setFont(new Font("Arial", Font.BOLD, 16));
		headerPanel.add(header);
		return headerPanel;
	}

	private JPanel createUserInfoPanel() {
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setLayout(new GridLayout(3, 2, 10, 10)); // Grid layout with 4 rows and 2 columns

		nameLabel = new JLabel("Name:");
		emailLabel = new JLabel("Email:");
		coursesLabel = new JLabel("Courses:");

		nameField = new JTextField(profileViewModel.getUser().getName());
		emailField = new JTextField(profileViewModel.getUser().getEmail());
		coursesField = new JTextField(profileViewModel.getUser().getCourses().toString()); // Assuming getCourses() returns a List or similar

		nameField.setEditable(false);
		emailField.setEditable(false);
		coursesField.setEditable(false);

		userInfoPanel.add(nameLabel);
		userInfoPanel.add(nameField);
		userInfoPanel.add(emailLabel);
		userInfoPanel.add(emailField);
		userInfoPanel.add(coursesLabel);
		userInfoPanel.add(coursesField);

		return userInfoPanel;
	}

	private JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		connect = new JButton("Connect"); // Create the connect button

		buttonsPanel.add(connect); // Add the connect button to the panel

		connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Handle connect button action here
				if (e.getSource().equals(connect)) {
					// connectController.execute();
				} else {
					//
				}
			}
		});

		return buttonsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		SignupState state = (SignupState) evt.getNewValue();
		if (state.getUsernameError() != null) {
			JOptionPane.showMessageDialog(this, state.getUsernameError());
		}
	}
}
