package view.user_signup_login;

import interface_adapter.signup.SignupController;

import java.util.ArrayList;
import java.util.List;


public class SignupLoginViewModel {
    // Properties
    private String username;
    private String email;
    private String errorMessage;
    private boolean isSignupSuccessful;
    private boolean isLoginSuccessful;

    private List<ViewModelObserver> observers = new ArrayList<>();


    public boolean isSignupSuccessful() { return isSignupSuccessful; }

    public boolean isLoginSuccessful() { return isLoginSuccessful; }

    public String getErrorMessage() { return errorMessage; }




    // Methods to update state
    public void signupSuccess() {
        this.isSignupSuccessful = true;
        this.isLoginSuccessful = false;
        this.errorMessage = null;
        notifyObservers();
    }

    public void signupFailure(String errorMessage) {
        this.isSignupSuccessful = false;
        this.errorMessage = errorMessage;
        notifyObservers();
    }

    public void loginSuccess() {
        this.isLoginSuccessful = true;
        this.errorMessage = null;
        notifyObservers();
    }

    public void loginFailure(String errorMessage) {
        this.isLoginSuccessful = false;
        this.errorMessage = errorMessage;
        notifyObservers();
    }

    public void addObserver(ViewModelObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (ViewModelObserver observer : observers) {
            observer.onViewModelChanged();
        }
    }


    public interface ViewModelObserver {
        void onViewModelChanged();
    }
}