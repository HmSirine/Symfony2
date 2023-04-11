/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mr.rhimi
 */
public class StatusPayment {
    
    
     
 
    public  Map<String, Object> GetStatus(String payment_id) {
           String API_URL = "https://developers.flouci.com/api/verify_payment/"+payment_id;
        try {
            URL url = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
               con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
         con.setRequestProperty("apppublic", "a2b986fe-7196-4fb3-8f77-e64bc828158d");
          con.setRequestProperty("appsecret", "e384abc1-5d1f-4ff6-a4f0-a269b2a637ac");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            
            // Parse the JSON response
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(content.toString(), JsonObject.class);
            
             Map<String, Object> MapJson = new HashMap<>();
            JsonObject main = json.getAsJsonObject("result");
            JsonElement statusElement = main.get("status");
          if (statusElement == null || statusElement.isJsonNull()) {
           throw new Exception("Status not found in JSON");
}       else {
            String status = main.get("status").getAsString();
            MapJson.put("status", status);
          }
            return  MapJson;
            // Get the "feels_like" temperature from the response
            //JsonObject main = json.getAsJsonObject("main");
          //  double feelsLike = main.get("feels_like").getAsDouble();
            
            
          //  System.out.println("Feels like: " + feelsLike);
           
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
        
       
          }
        
   
  
    
}
