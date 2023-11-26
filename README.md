

# Group 195 final project

## Overview

This project is a social platform designed for students to connect based on shared courses. It allows users to sign up, log in, view other students' profiles, and initiate connections via email for academic networking and collaboration.

## Features

- **User Authentication**: Secure sign-up and log-in functionality.
- **Course Matching**: Users can enter their courses during sign-up, which the platform uses for matching.
- **Profile Browsing**: Users can view a listing of the names and courses information of other users ranked based on
- similarity of taking courses.
- **Connecting**: Users can send a connection email through the platform to users with shared courses of their choice.
  (Email API: Send Grid)

## Getting Started

### Prerequisites

- List of prerequisites and dependencies
- Required software (e.g., browser versions, server requirements)


## Usage

### Signing Up

1. Navigate to the sign-up page.
2. Enter your personal details and the courses you're taking.
3. Confirm your email address to complete the registration.

### Logging In

1. Navigate to the login page.
2. Enter your username and password to access the platform.

### Browsing Profiles

- On the homepage, browse through user cards to see other students' names and courses.
- Click on a card to view detailed information about that user.

### Connecting with Other Users

1. On a user's profile, click the "Connect" button.
2. Enter a personalized message if desired.
3. Click 'Send' to email the other user with your contact details and shared courses.

## API Documentation

*https://docs.sendgrid.com/for-developers*

## Support and Troubleshooting

For any issues or support, please file an issue in the repository, detailing the problem and steps to reproduce it.

## Authors

- **Rogers Yang** Self User Profile Usecase, Other user profile use case, Connected Usecases and wrote up Main.java
- **Wenyu Qiu**  UserList usecase, connect to SendGrid API, create html email template, UserSecession class
- **Ziyi Ye** Sign Up usecase, Log in Usecase
- **YiGe Yan** Connect Usecase 

## Acknowledgments

- The project is created for the course CSC207's assignment purpose. It is incomplete and can be extended by: 
  - Allow modify user profile. 
  - Allow user sign out. 
  - Allow customized standard in ranking other users. 
  - connect to Pronounciation APIs to allow blind people to use the app.
- We strongly appreciate teaching asistant Ruihuan He's asistance.

