package view.signup_login;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class SignupView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;

    private final SignupController signupController;

    private final JTextField usernameInputField = new JTextField(15);

    private final JPasswordField passwordInputField = new JPasswordField(15);

    private final JTextField emailInputField = new JTextField(15);

//    private final JTextField course1InputField = new JTextField(5);
//
//    private final JTextField course2InputField = new JTextField(5);
//
//    private final JTextField course3InputField = new JTextField(5);
//
//    private final JTextField course4InputField = new JTextField(5);
//
//    private final JTextField course5InputField = new JTextField(5);


    private final JTextField[] courseInputFields = new JTextField[5];

    private JButton signUp;

    private JButton cancel;

//    private JFrame jFrame;




    public SignupView(SignupController controller,
                      SignupViewModel signupViewModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        initializeComponents();
//        this.defaultValueInitialization();
//        this.defaultComponentsInitialization();

//        this.infFieldKey(); //for username, password, email
//        this.courseFieldKey(); //for all five courses
    }

//    private void infFieldKey(){
//        usernameInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = usernameInputField.getText() + e.getKeyChar();
//                        currentState.setUsername(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {}
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {}
//                }
//        );
//
//        passwordInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = passwordInputField.getText() + e.getKeyChar();
//                        currentState.setPassword(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                }
//        );
//
//        emailInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = emailInputField.getText() + e.getKeyChar();
//                        currentState.setEmail(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                }
//        );
//    }
//
//    private void courseFieldKey(){
//        course1InputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = course1InputField.getText() + e.getKeyChar();
//                        currentState.setCourse1(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {}
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {}
//                }
//        );
//
//        course2InputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = course2InputField.getText() + e.getKeyChar();
//                        currentState.setCourse2(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {}
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {}
//                }
//        );
//
//        course3InputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = course3InputField.getText() + e.getKeyChar();
//                        currentState.setCourse3(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {}
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {}
//                }
//        );
//
//        course4InputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = course4InputField.getText() + e.getKeyChar();
//                        currentState.setCourse4(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {}
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {}
//                }
//        );
//
//        course5InputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = course5InputField.getText() + e.getKeyChar();
//                        currentState.setCourse5(text);
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {}
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {}
//                }
//        );
//    }

//    private void defaultValueInitialization() {
////        //set app name at the centre
////        JLabel appName = new JLabel("195FinalProjectName");
////        appName.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        int WIDTH = 800;
//        int HEIGHT = 400;
//
//        // use frame?
//        this.jFrame = new JFrame("195FinalProjectName");
//        this.jFrame.setSize(WIDTH, HEIGHT);
//        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

    private void defaultComponentsInitialization(){
        // Use GridBagLayout for arranging components
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10); // Padding

        //add signup and cancel button
        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_LABEL);
        buttons.add(signUp, constraints);
        constraints.gridx = 1;

        cancel = new JButton(SignupViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel, constraints);
        constraints.gridx = 1;

    }

    private void initializeComponents() {
        setLayout(new GridBagLayout());
        setBackground(new Color(30, 30, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10); // Padding

        //labels
        addLabelAndField("Username:", new JTextField(15), constraints);
        addLabelAndField("Password:", new JPasswordField(15), constraints);
        addLabelAndField("Email:", new JTextField(15), constraints);

        //course field in a single line
        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        coursePanel.setBackground(new Color(30, 30, 30));
        for (int i = 1; i <= 5; i++) {
            addCourseField("Course " + i + ":", coursePanel);
        }
        add(coursePanel, constraints);
        constraints.gridy++;


        // buttons
        JButton signUp = createButton("Sign Up", constraints);
        signUp.addActionListener(e -> handleSignUp());
        JButton cancel = createButton("Cancel", constraints);
    }

    private void handleSignUp() {
        String username = usernameInputField.getText();
        String password = new String(passwordInputField.getPassword());
        String email = emailInputField.getText();
        ArrayList<String> courses = new ArrayList<>();
        for (JTextField courseField : courseInputFields) {
            courses.add(courseField.getText());
        }

        // Pass data to the controller
        signupController.execute(username, password, "1", email, courses);
    }

    private void addCourseField(String labelText, JPanel panel) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField field = new JTextField(8); // Half-width field
        field.setBackground(new Color(50, 50, 50));
        field.setForeground(Color.WHITE);
        panel.add(label);
        panel.add(field);
    }

    private void addLabelAndField(String labelText, JComponent field, GridBagConstraints constraints) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label, constraints);
        constraints.gridy++;
        field.setBackground(new Color(50, 50, 50));
        field.setForeground(Color.WHITE);
        add(field, constraints);
        constraints.gridy++;
    }

    private JButton createButton(String text, GridBagConstraints constraints) {
        JButton button = new JButton(text);
        button.setBackground(new Color(50, 50, 50));
        button.setForeground(Color.WHITE);
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
