package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.connect.ConnectController;
import interface_adapter.other_profile.OtherProfileController;
import interface_adapter.other_profile.OtherProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A dialog window that displays the profile of another user.
 * It allows interaction and connection with the user's profile.
 */
public class OtherProfileView extends JPanel implements ActionListener, PropertyChangeListener {
	public final String viewName = "other_profile";
	private final ConnectController connectController;
	private OtherProfileViewModel profileViewModel;
	private final OtherProfileController profileController;
	private JLabel nameLabel, emailLabel, coursesLabel;
	private JLabel nameField, emailField, coursesField;
	private JButton connect, backButton;
	private final ViewManagerModel viewManagerModel;


	/**
	 * Constructs an OtherProfileView dialog.
	 *
	 * @param profileViewModel   The ViewModel providing data for the user profile.
	 * @param profileController  The controller managing interactions with the user profile.
	 * @param connectController  The controller to manage connections.
	 */
	public OtherProfileView(OtherProfileViewModel profileViewModel,
	                        OtherProfileController profileController,
	                        ConnectController connectController,
	                        ViewManagerModel viewManagerModel) {

		this.profileController = profileController;
		this.profileViewModel = profileViewModel;
		this.profileViewModel.addPropertyChangeListener(this);
		this.connectController = connectController;
		this.viewManagerModel = viewManagerModel;


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
					/**
					 * Handles action events from the dialog components.
					 *
					 * @param e The action event.
					 */
					@Override
					public void actionPerformed(ActionEvent e) {
						// Handle connect button action here
						if (e.getSource().equals(connect)) {
							//SwingUtilities.invokeLater(() -> new ConnectView(connectController));  // Invoke the new view.
							connectController.initiateConnectionProcess(profileViewModel.getState().getUserEmail());
						}
					}
				}
		);

		backButton = new JButton("Go Back");
		backButton.addActionListener(e -> goBack());

		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(backButton);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.add(title);
		centerPanel.add(usernameInfo);
		centerPanel.add(emailInfo);
		centerPanel.add(coursesInfo);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(topPanel);
		add(centerPanel);
		add(buttons);
		setSize(400, 300);
	}

	/**
	 * Initializes the UI components for the dialog.
	 */
	private void createUserInfo() {
		nameLabel = new JLabel("Name:");
		emailLabel = new JLabel("Email:");
		coursesLabel = new JLabel("Courses:");


		nameField = new JLabel("");
		emailField = new JLabel("");
		coursesField = new JLabel(""); // Assuming getCourses() returns a List or similar

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(this, "Test Activated");
	}

	/**
	 * Updates the dialog based on property changes in the ViewModel.
	 *
	 * @param evt The property change event.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("state".equals(evt.getPropertyName())) {
			nameField.setText(profileViewModel.getState().getUserName());
			emailField.setText(profileViewModel.getState().getUserEmail());
			String courses = profileViewModel.getState().getUserCourses().toString();
			coursesField.setText(courses.substring(1, courses.length()-1));
		}
	}

	public void goBack() {
		String previousView = viewManagerModel.getPreviousView();
		if (previousView != null) {
			// Assuming that the ViewManagerModel can trigger a view change.
			// You might need to adjust this based on your implementation.
			viewManagerModel.setActiveView(previousView);
			viewManagerModel.firePropertyChanged();
		}
	}
}
