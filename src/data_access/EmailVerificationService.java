package data_access;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class EmailVerificationService {
    public static boolean verifyEmail3(String email){


        String keyId = "553";
        String keyCode = "x9ftgww3dtmtbwpmd4pybvb7";


        String urlString = "http://api.moonapi.com/442?apicode=email&keyid=" + keyId + "&sign="
                + keyCode + "&email=" + email;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            int responseCode = conn.getResponseCode();
            InputStream inputStream = (responseCode == HttpURLConnection.HTTP_OK) ? conn.getInputStream() : conn.getErrorStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            System.out.println("HTTP Response Code: " + responseCode);
            System.out.println("HTTP Response Body: " + response.toString());


            JSONObject responseJson = new JSONObject(response.toString());

            String status = responseJson.getString("status");

            JSONObject data = responseJson.getJSONObject("data");
            String dataStatus = data.getString("status");

            return status.equals("success") && dataStatus.equals("success");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

}
