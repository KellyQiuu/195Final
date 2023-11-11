package interface_adapter.profile;

import use_case.email_user.EmailService;
import use_case.profile.ProfileInputBoundary;
import entity.User;
import view.ProfileView;

public class ProfileController {
	private final ProfileInputBoundary profileInteractor;
	private final EmailService emailService;
	private final ProfileView profileView;

	public ProfileController(ProfileInputBoundary profileInteractor, EmailService emailService, ProfileView profileView) {
		this.profileInteractor = profileInteractor;
		this.emailService = emailService;
		this.profileView = profileView;
	}

	public void onConnectButtonClick(User recipient, String freeTextMessage) {
		try {
			// Assume EmailService.sendEmail throws an exception if email sending fails
			EmailService.sendEmail(recipient, freeTextMessage);
			// If email was sent successfully, show a success message
			profileView.showSuccessMessage();
		} catch (Exception e) {
			// Log the exception and show an error message
			e.printStackTrace();
			profileView.showErrorMessage("Failed to send email. Please try again later.");
		}
	}
	public void execute(String username) {
		profileInteractor.execute(username);
	}
}
