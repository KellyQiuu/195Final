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

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(title);
		this.add(usernameInfo);
		this.add(emailInfo);
		this.add(coursesInfo);
		this.add(buttons);

	}

	private void createUserInfo() {
		nameLabel = new JLabel("Name:");
		emailLabel = new JLabel("Email:");
		coursesLabel = new JLabel("Courses:");

		nameField = new JTextField(profileViewModel.getUser().getName());
		emailField = new JTextField(profileViewModel.getUser().getEmail());
		coursesField = new JTextField(profileViewModel.getUser().getCourses().toString()); // Assuming getCourses() returns a List or similar

		nameField.setEditable(false);
		emailField.setEditable(false);
		coursesField.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("username".equals(evt.getPropertyName())) {
			nameField.setText(evt.getNewValue().toString());
		}
	}


}
