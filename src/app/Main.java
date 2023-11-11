package app;

import entity.User;
import entity.UserFactory;

import java.util.ArrayList;
import use_case.EmailService;



public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> courses = new ArrayList<>();

        User u=UserFactory.creatUser("User1","123","1","qiuwenyu2021@outlook.com",courses);


        EmailService.sendEmail(u);


    }
}