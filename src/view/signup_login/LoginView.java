package view.signup_login;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";

    private final LoginViewModel loginViewModel;

    private final LoginController loginController;

    private final JTextField usernameInputField = new JTextField(15);

    private final JPasswordField passwordInputField = new JPasswordField(15);

    private JButton logIn;

    private JButton cancel;

    public LoginView(LoginController controller, LoginViewModel loginViewModel) {
        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridBagLayout());
        setBackground(new Color(30, 30, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10); // Padding

        //Sign up Title label
        JLabel titleLabel = new JLabel("Log in!");
        titleLabel.setForeground(Color.WHITE); // Set text color to white
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center align
        add(titleLabel, constraints);
        constraints.gridy++;


        //labels
        addLabelAndField("Username:", usernameInputField, constraints);
        addLabelAndField("Password:", passwordInputField, constraints);

        // buttons
        JButton signUp = createButton("Login in!", constraints);
        signUp.addActionListener(e -> {
            try {
                handleLogin();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton cancel = createButton("Cancel", constraints);
        cancel.addActionListener(e -> {
            JFrame parentFrame = getParentFrame();
            if (parentFrame != null) {
                parentFrame.dispose();
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

    private void handleLogin() throws IOException {
        String username = usernameInputField.getText();

        LoginState currentState = loginViewModel.getState();
        currentState.setUsername(username);
        loginViewModel.setState(currentState);

        String password = new String(passwordInputField.getPassword());
        currentState.setPassword(password);
        loginViewModel.setState(currentState);

        loginController.execute(username, password);
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
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
    }

}
