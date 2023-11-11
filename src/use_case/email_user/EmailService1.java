package use_case.email_user;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import org.json.JSONObject;
import org.json.JSONArray;
import entity.User;

public class EmailService {
    private static final String SENDGRID_API_URL = "https://api.sendgrid.com/v3/mail/send";
    private final String sendGridApiKey;

    public EmailService(String apiKey) {
        this.sendGridApiKey = apiKey;
    }

    public void sendEmail(User recipient, String freeTextMessage) throws Exception {
        JSONObject emailJson = new JSONObject();

        // Set the sender's email
        JSONObject fromObject = new JSONObject();
        fromObject.put("email", "your-email@example.com"); // Replace with your sending email address
        emailJson.put("from", fromObject);

        // Set the recipient
        JSONObject toObject = new JSONObject();
        toObject.put("email", recipient.getEmail());

        JSONArray tosArray = new JSONArray();
        tosArray.put(toObject);

        // Set the personalization
        JSONObject personalizationObject = new JSONObject();
        personalizationObject.put("to", tosArray);

        // Add dynamic template data here
        JSONObject dynamicData = new JSONObject();
        dynamicData.put("name", recipient.getName());
        dynamicData.put("course", String.join(", ", recipient.getCourses())); // Assuming courses is a list of strings
        dynamicData.put("free_text", freeTextMessage);
        personalizationObject.put("dynamic_template_data", dynamicData);

        JSONArray personalizations = new JSONArray();
        personalizations.put(personalizationObject);
        emailJson.put("personalizations", personalizations);

        // Set the template ID
        emailJson.put("template_id", "d-1234567890abcdef1234567890abcdef"); // Replace with your actual template ID

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SENDGRID_API_URL))
                .header("Authorization", "Bearer " + this.sendGridApiKey)
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(emailJson.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 202) {
            System.out.println("Email sent successfully.");
        } else {
            System.out.println("Failed to send email with status code: " + response.statusCode());
            System.out.println("Response: " + response.body());
            // You might want to throw an exception or handle the error appropriately
        }
    }
}
