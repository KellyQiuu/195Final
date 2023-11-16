package interface_adapter.signup;

public class SignupState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String email = "";
    private String emailError = null;
    private String course1 = "";
    private String course2 = "";
    private String course3 = "";
    private String course4 = "";
    private String course5 = "";

    public SignupState(SignupState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
        email = copy.email;
        emailError = copy.emailError;
        course1 = copy.course1;
        course2 = copy.course2;
        course3 = copy.course3;
        course4 = copy.course4;
        course5 = copy.course5;
    }

    public SignupState() {}

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setUsername(String username) {this.username = username;}

    public void setUsernameError(String usernameError) {this.usernameError = usernameError;}

    public void setPassword(String password) {this.password = password;}

    public void setPasswordError(String passwordError) {this.passwordError = passwordError;}

    public void setEmail(String email) {this.email = email;}

    public void setEmailError(String emailError) {this.emailError = emailError;}

    public void setCourse1(String course1) {this.course1 = course1;}

    public void setCourse2(String course2) {this.course2 = course2;}

    public void setCourse3(String course3) {this.course3 = course3;}

    public void setCourse4(String course4) {this.course4 = course4;}

    public void setCourse5(String course5) {this.course5 = course5;}

    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email = '" + email + '\'' +
                ", course1 = '" + course1 + '\'' +
                ", course2 = '" + course2 + '\'' +
                ", course3 = '" + course3 + '\'' +
                ", course4 = '" + course4 + '\'' +
                ", course5 = '" + course5 + '\'' +
                '}';
    }
}
