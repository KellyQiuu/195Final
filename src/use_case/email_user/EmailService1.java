package use_case.email_user;

import entity.User;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import org.json.JSONObject;
import org.json.JSONArray;

public class EmailService {
    private static final String SENDGRID_API_URL = "https://api.sendgrid.com/v3/mail/send";
    private String sendGridApiKey; // The API Key for SendGrid

    public EmailService(String apiKey) {
        this.sendGridApiKey = apiKey;
    }

    public void sendEmail(User recipient, String freeTextMessage) throws Exception {
        JSONObject emailJson = new JSONObject();
        emailJson.put("from", new JSONObject().put("email", "from_email@example.com")); // Replace with your 'from' address

        JSONArray personalizationsArray = new JSONArray();
        JSONObject personalizationObject = new JSONObject();
        personalizationObject.put("to", new JSONArray().put(new JSONObject().put("email", recipient.getEmail())));
        personalizationObject.put("dynamic_template_data", new JSONObject().put("free_text", freeTextMessage));
        personalizationsArray.put(personalizationObject);
        emailJson.put("personalizations", personalizationsArray);

        emailJson.put("template_id", "your-template-id"); // Replace with your SendGrid template ID

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SENDGRID_API_URL))
                .header("Authorization", "Bearer " + this.sendGridApiKey)
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(emailJson.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 202) {
            System.out.println("Email sent successfully to " + recipient.getEmail());
        } else {
            System.out.println("Failed to send email with status code: " + response.statusCode());
            throw new Exception("Email sending failed: " + response.body());
        }
    }
}
