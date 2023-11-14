package app;

import use_case.SessionManagerInteractor;
import entity.User;
import entity.UserFactory;

import java.util.ArrayList;
import use_case.email_user.EmailService;



public class Main {
    //Initialization
    //// This setup code would typically go in your main method or application initialization logic
    //
    //// Create the dependencies of the ProfileController
    //ProfileInputBoundary profileInteractor = new ProfileInteractor(/* dependencies */);
    //EmailService emailService = new EmailService(/* your SendGrid API key */);
    //ProfileView profileView = new ProfileView(/* ProfileViewModel */, /* ProfileController */);
    //
    //// Create the ProfileController
    //ProfileController profileController = new ProfileController(profileInteractor, emailService, profileView);
    //
    //// Now that ProfileController is created, you must set it in the ProfileView
    //profileView.setController(profileController);
    public static void main(String[] args) throws Exception {
        ArrayList<String> courses = new ArrayList<>();

        User u=UserFactory.creatUser("User1","123","1","qiuwenyu2021@outlook.com",courses);


        //EmailService.sendEmail(u, freeTextMessage);
        SessionManagerInteractor sessionManager = new SessionManagerInteractor();
        User user = UserFactory.creatUser("Lynnesy", "wenyu.qiu@mail.utoronto.ca","0",
                "wenyu.qiu@mail.utoronto.ca", new ArrayList<String>());
        sessionManager.createUserSession(user);

// When you need to retrieve the current user
        User currentUser = sessionManager.getCurrentUser();
        if (currentUser != null) {
            // User is logged in
            System.out.println("Current user ID: " + currentUser.getId());
        } else {
            // No user is currently logged in
        }

// When the user logs out
        sessionManager.endUserSession();


    }
}