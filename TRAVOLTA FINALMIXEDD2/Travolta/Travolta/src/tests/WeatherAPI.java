/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mr.rhimi
 */
public class WeatherAPI {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=Tunis&appid=a0f2555640582759910dbd717e8d1926";
 
    public  Map<String, Object> Getweather() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
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
            
             Map<String, Object> weatherData = new HashMap<>();
            JsonObject main = json.getAsJsonObject("main");
            double temperature = main.get("temp").getAsDouble();
            double feelsLike = main.get("feels_like").getAsDouble();
            double humidity = main.get("humidity").getAsDouble();
            weatherData.put("temperature", temperature);
            weatherData.put("feelsLike", feelsLike);
            weatherData.put("humidity", humidity);
            
            // Get the "feels_like" temperature from the response
            //JsonObject main = json.getAsJsonObject("main");
          //  double feelsLike = main.get("feels_like").getAsDouble();
            
            
          //  System.out.println("Feels like: " + feelsLike);
           return  weatherData;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
        
       
          }
        
   
  
}