package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserCardPanel extends JPanel {
    private String userDisplayInfo;

    public UserCardPanel(String userName, ArrayList<String> courses) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // for card-like appearance

        // Format the courses as a comma-separated string without brackets
        String coursesString = String.join("/ ", courses);
        coursesString =coursesString.substring(1, coursesString.length() - 1);

        // Combine the user's name and their formatted courses into one HTML string
        userDisplayInfo = "<html>" + userName + "<br>Courses: " + coursesString + "</html>";

        add(new JLabel(userDisplayInfo), BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, 100));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userCardClicked(userName);
            }
        });
    }

    private void userCardClicked(String userName) {
        JOptionPane.showMessageDialog(this, "Details for " + userName + " clicked!");
    }
}



