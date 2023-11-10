package view.user_signup_login;

import javax.swing.*;
import java.awt.*;

public class SignupView extends Component {
    // TODO: 11/10/2023 complete view /GUI components
    public void Success(String message) {
        JOptionPane.showMessageDialog(this, message, "Signup Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Signup Error", JOptionPane.ERROR_MESSAGE);
    }

}
