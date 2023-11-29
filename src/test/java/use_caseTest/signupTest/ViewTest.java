//package use_caseTest.signupTest;
//
//import app.UsecaseFactory.LoginUseCaseFactory;
//import app.UsecaseFactory.SignupUseCaseFactory;
//import app.UsecaseFactory.UserListUseCaseFactory;
//import data_access.UserDataAccessObject;
//import entity.UserFactory;
//import interface_adapter.login.LoginViewModel;
//import interface_adapter.other_profile.OtherProfileViewModel;
//import interface_adapter.self_profile.SelfProfileViewModel;
//import interface_adapter.signup.SignupViewModel;
//import interface_adapter.ViewManagerModel;
//import use_case.other_profile.OtherProfileDataAccessInterface;
//import use_case.self_profile.SelfProfileDataAccessInterface;
//import use_case.user_list.UserListDataAccessInterface;
//import view.signup_login.LoginView;
//import view.signup_login.SignupView;
//
//import view.ViewManager;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//
//import view.UserListView;
//import view.UserListViewModel;
//
//public class ViewTest {
//
//    public static void main(String[] args) throws  IOException{
//
//        JFrame application = new JFrame("195 final project");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//
//        JPanel views = new JPanel(cardLayout);
//        application.add(views);
//
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(views, cardLayout, viewManagerModel);
//
//        LoginViewModel loginViewModel = new LoginViewModel();
//        SignupViewModel signupViewModel = new SignupViewModel();
//        UserListViewModel userListViewModel = new UserListViewModel();
//
//
//        UserDataAccessObject userDataAccessObject;
//
//        try {
//            userDataAccessObject = new UserDataAccessObject(new UserFactory());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
//                signupViewModel, userDataAccessObject);
//        assert signupView != null;
//        views.add(signupView, signupView.viewName);
//
//        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, userListViewModel,userDataAccessObject);
//        assert loginView != null;
//        views.add(loginView, loginView.viewName);
//
//
//        viewManagerModel.setActiveView(signupView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        application.pack();
//        application.setVisible(true);
//
//    }
//
//}
