package view;

import interface_adapter.connect.ConnectController;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OtherProfileView extends JDialog implements ActionListener, PropertyChangeListener {
	public final String viewName = "other_profile";

	private final ConnectController connectController;
	private OtherProfileViewModel profileViewModel;
	private final OtherProfileController profileController;

	private JLabel nameLabel, emailLabel, coursesLabel;
	private JTextField nameField, emailField, coursesField;
	private JButton connect;


	public OtherProfileView(OtherProfileViewModel profileViewModel, OtherProfileController profileController, ConnectController connectController) {

		this.profileController = profileController;
		this.profileViewModel = profileViewModel;
		this.profileViewModel.addPropertyChangeListener(this);
		this.connectController = connectController;

		JLabel title = new JLabel(OtherProfileViewModel.TITLE_LABEL);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		createUserInfo();

		LabelTextPanel usernameInfo = new LabelTextPanel(nameLabel, nameField);
		LabelTextPanel emailInfo = new LabelTextPanel(emailLabel, emailField);
		LabelTextPanel coursesInfo = new LabelTextPanel(coursesLabel, coursesField);

		JPanel buttons = new JPanel();
		connect = new JButton(OtherProfileViewModel.CONNECT_BUTTON_LABEL);
		buttons.add(connect);

		connect.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Handle connect button action here
						if (e.getSource().equals(connect)) {
							SwingUtilities.invokeLater(() -> new ConnectView(connectController));  // Invoke the new view.
						}
					}
				}
		);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(title);
		add(usernameInfo);
		add(emailInfo);
		add(coursesInfo);
		add(buttons);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the window closes properly
		setLocationRelativeTo(null); // Center the window on the screen
		setVisible(true); // Make the window visible
	}

	private void createUserInfo() {
		nameLabel = new JLabel("Name:");
		emailLabel = new JLabel("Email:");
		coursesLabel = new JLabel("Courses:");


		nameField = new JTextField("");
		emailField = new JTextField("");
		coursesField = new JTextField(""); // Assuming getCourses() returns a List or similar

		nameField.setEditable(false);
		emailField.setEditable(false);
		coursesField.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(this, "actionPerformed");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("state".equals(evt.getPropertyName())) {
			nameField.setText(profileViewModel.getState().getUserName());
			emailField.setText(profileViewModel.getState().getUserEmail());
			coursesField.setText(profileViewModel.getState().getUserCourses().toString());
		}
	}
}
