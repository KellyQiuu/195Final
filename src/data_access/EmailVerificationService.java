package data_access;

import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class EmailVerificationService {
    public static boolean verifyEmail(String email) {
        try {
            URL url = new URL("https://api.nbhao.org/v1/email/verify");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            String jsonInputString = "{\"email\": \"" + email + "\"}";

            // Debug print
            System.out.println("Sending JSON: " + jsonInputString);

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Print the entire JSON response
                System.out.println("API Response: " + jsonResponse.toString());

                // Check if the response code is 200
                return jsonResponse.getInt("code") == 200;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verifyEmail2(String email) {
        String mtb_data = "";
        try {
            URL url = new URL( "http(s)://www.maitanbang.com/apis/mtbvemail/");
            HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoOutput(true);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            OutputStream outputStream = conn.getOutputStream();
            String content = "key=你的APIKEY&word=";
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
            InputStream inputStream = conn.getInputStream();
            byte[] data = new byte[1024];
            StringBuilder mtbapi = new StringBuilder();
            while (inputStream.read(data) != -1) {
                String t = new String(data);
                mtbapi.append(t);
            }
            mtb_data = mtbapi.toString();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(mtb_data);

        return mtb_data.equals("200");
    }

}
