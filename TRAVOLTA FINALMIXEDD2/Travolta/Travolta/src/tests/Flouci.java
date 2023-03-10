/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mr.rhimi
 */
public class Flouci {

    /**
     * @param args the command line arguments
     */
     private static final String API_URL="https://developers.flouci.com/api/generate_payment";
    public Map<String, Object> MakeFlous() throws IOException {
      URL url = null;
        try {
            url = new URL(API_URL);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Flouci.class.getName()).log(Level.SEVERE, null, ex);
        }
HttpURLConnection http = (HttpURLConnection)url.openConnection();
http.setRequestMethod("POST");
http.setDoOutput(true);
http.setRequestProperty("Accept", "application/json");
http.setRequestProperty("Content-Type", "application/json");

String data = "{\n" +
"  \"app_token\": \"a2b986fe-7196-4fb3-8f77-e64bc828158d\",\n" +
"  \"app_secret\": \"e384abc1-5d1f-4ff6-a4f0-a269b2a637ac\",\n" +
"   \"accept_card\": \"true\",\n" +
"  \"amount\": \"300000\",\n" +
"  \"success_link\": \"https://example.website.com/success\",\n" +
"  \"fail_link\": \"https://example.website.com/fail\",\n" +
"  \"session_timeout_secs\": 4,\n" +
"  \"developer_tracking_id\": \"98726384956\"\n" +
"}";

byte[] out = data.getBytes(StandardCharsets.UTF_8);

OutputStream stream = http.getOutputStream();
stream.write(out);

System.out.println(http.getResponseCode() + " " + http.getResponseMessage());

BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream(), StandardCharsets.UTF_8));
StringBuilder responseBuilder = new StringBuilder();
String responseLine;

while ((responseLine = reader.readLine()) != null) {
    responseBuilder.append(responseLine.trim());
}

String response = responseBuilder.toString();

System.out.println(response);

// Parse the JSON response using Gson
Gson gson = new Gson();
JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

// Extract the success link from the JSON object

 Map<String, Object> FlouciReponse = new HashMap<>();
            JsonObject main = jsonObject.getAsJsonObject("result");
            String paymentId = main.get("payment_id").getAsString();
             String link = main.get("link").getAsString();
              String montant = main.get("link").getAsString();
      
           // FlouciReponse.put("payment_id", montant);
            FlouciReponse.put("payment_id", paymentId);
              FlouciReponse.put("link", link);
              

// String paymentId = jsonObject.get("payment_id").getAsString();

//System.out.println(FlouciReponse.get("payment_id"));
//System.out.println(FlouciReponse.get("link"));

http.disconnect();
         return FlouciReponse;







}
}