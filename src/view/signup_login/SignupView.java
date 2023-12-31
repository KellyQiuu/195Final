package view.signup_login;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class SignupView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;

    private final SignupController signupController;

    private final ViewManagerModel  viewManagerModel;

    private final JTextField usernameInputField = new JTextField(15);

    private final JPasswordField passwordInputField = new JPasswordField(15);

    private final JTextField emailInputField = new JTextField(15);

    private final JTextField[] courseInputFields = new JTextField[5];

    private final JTextField course1InputField = new JTextField(8);

    private final JTextField course2InputField = new JTextField(8);

    private final JTextField course3InputField = new JTextField(8);

    private final JTextField course4InputField = new JTextField(8);

    private final JTextField course5InputField = new JTextField(8);

    private JButton signUp;

    private JButton cancel;


    public SignupView(SignupController controller,
                      SignupViewModel signupViewModel,
                      ViewManagerModel viewManagerModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        signupViewModel.addPropertyChangeListener(this);
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridBagLayout());
//        setBackground(new Color(30, 30, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10); // Padding

        // Final Project Name.
        JLabel titleLabel_projectname = new JLabel("CourseMate Connect");
        titleLabel_projectname.setForeground(Color.DARK_GRAY); // Set text color to white
        titleLabel_projectname.setFont(new Font("Arial", Font.BOLD, 30)); // Customize font
        titleLabel_projectname.setHorizontalAlignment(JLabel.CENTER); // Center align
        add(titleLabel_projectname, constraints);
        constraints.gridy++;

        //Sign up Title label
        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setForeground(Color.DARK_GRAY); // Set text color to white
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center align
        add(titleLabel, constraints);
        constraints.gridy++;

        //labels
        addLabelAndField("Username:", usernameInputField, constraints);
        addLabelAndField("Password:", passwordInputField, constraints);
        addLabelAndField("Email:", emailInputField, constraints);



        //course field in a single line
        JPanel coursePanel2 = new JPanel();
        coursePanel2.setLayout(new BoxLayout(coursePanel2, BoxLayout.X_AXIS));
        addCourseField("Course 1:", course1InputField, coursePanel2);
        addCourseField("Course 2:", course2InputField, coursePanel2);
        addCourseField("Course 3:", course3InputField, coursePanel2);
        addCourseField("Course 4:", course4InputField, coursePanel2);
        addCourseField("Course 5:", course5InputField, coursePanel2);
        add(coursePanel2, constraints);
        constraints.gridy++;


        // buttons
        JButton signUp = createButton("Sign Up", constraints);
        signUp.addActionListener(e -> handleSignUp());

        JButton cancel = createButton("Cancel", constraints);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManagerModel.setActiveView("MainPageView");
                viewManagerModel.firePropertyChanged(); // Notify the change to update the view
            }
        });

    }

    private JFrame getParentFrame() {
        Component component = this;
        while (component != null && !(component instanceof JFrame)) {
            component = component.getParent();
        }
        return (JFrame) component;
    }


    private void handleSignUp() {
        String username = usernameInputField.getText();

        SignupState currentState = signupViewModel.getState();
        currentState.setUsername(username);
        signupViewModel.setState(currentState);

        String password = new String(passwordInputField.getPassword());
        currentState.setPassword(password);
        signupViewModel.setState(currentState);


        String email = emailInputField.getText();
        currentState.setEmail(email);
        signupViewModel.setState(currentState);


        //=============== for 5 courses
        ArrayList<String> courses = new ArrayList<>();

        String c1 = course1InputField.getText();
        courses.add(c1);
        currentState.setCourse1(c1);
        signupViewModel.setState(currentState);

        String c2 = course2InputField.getText();
        courses.add(c2);
        currentState.setCourse2(c2);
        signupViewModel.setState(currentState);

        String c3 = course3InputField.getText();
        courses.add(c3);
        currentState.setCourse3(c3);
        signupViewModel.setState(currentState);

        String c4 = course4InputField.getText();
        courses.add(c4);
        currentState.setCourse4(c4);
        signupViewModel.setState(currentState);

        String c5 = course5InputField.getText();
        courses.add(c5);
        currentState.setCourse5(c5);
        signupViewModel.setState(currentState);

        //================

//        for (int i = 0; i < 5; i++) {
//            courses.add(courseInputFields[i].getText());
//        }

//          ================================
//        for (JTextField courseField : courseInputFields) {
//            courses.add(courseField.getText());
//        }

        // Pass data to the controller
        signupController.execute(username, password, "1", email, courses);
    }

    private void addCourseField(String labelText, JTextField field, JPanel panel) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("Arial", Font.BOLD, 14));
//        field.setBackground(new Color(50, 50, 50));
//        field.setForeground(Color.WHITE);
        field.setColumns(8);
        panel.add(label);
        panel.add(field);
    }

    private void addLabelAndField(String labelText, JComponent field, GridBagConstraints constraints) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label, constraints);
        constraints.gridy++;
//        field.setBackground(new Color(50, 50, 50));
//        field.setForeground(Color.WHITE);
        add(field, constraints);
        constraints.gridy++;
    }

    private JButton createButton(String text, GridBagConstraints constraints) {
        JButton button = new JButton(text);
        button.setBackground(Color.RED);
        button.setForeground(Color.DARK_GRAY);
        button.setBackground(Color.BLACK); // Set background color to black
        button.setSize(20, 5);
        add(button, constraints);
        constraints.gridy++;
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
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
