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
    private static final String YOUR_TEMPLATE_ID = "d-6706faa3bb9543ec9fddfceb21d6d7fb";
    private static final String SENDGRID_API_KEY = "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";

    public static void sendEmail(User current, String otherEmail, String freeTextMessage) throws Exception {
        JSONObject emailJson = new JSONObject();
        // Create a 'from' object with an email address
        JSONObject fromObject = new JSONObject();
        fromObject.put("email", "qiuwenyu60@gmail.com"); // Replace with your send address
        // Optionally you can add a name to the 'from' object
        // fromObject.put("name", "Your Name");
        emailJson.put("from", fromObject);
        emailJson.put("template_id", "d-6706faa3bb9543ec9fddfceb21d6d7fb");

        JSONObject to = new JSONObject();
        to.put("email", otherEmail);

        JSONArray tos = new JSONArray();
        tos.put(to);

        JSONObject personalization = new JSONObject();
        personalization.put("to", tos);
        JSONObject dynamicData = new JSONObject();
        dynamicData.put("name", current.getName());
        dynamicData.put("email",current.getEmail());
        dynamicData.put("course", current.getCourses());
        System.out.println("Free text received is :"+ freeTextMessage);
        dynamicData.put("freetext", freeTextMessage);
        personalization.put("dynamic_template_data", dynamicData);
        System.out.println("Dynamic Data is"+dynamicData); //debug line

        JSONArray personalizations = new JSONArray();
        personalizations.put(personalization);

        emailJson.put("personalizations", personalizations);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SENDGRID_API_URL))
                .header("Authorization", "Bearer " + SENDGRID_API_KEY)
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(emailJson.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Check response status code and log the response
        if (response.statusCode() == 202) {
            System.out.println("Email sent successfully.");
            System.out.println("Response: " + response.body());
        } else {
            System.out.println("Email send failed with status code: " + response.statusCode());
            System.out.println("Response: " + response.body());
        }
    }
}
