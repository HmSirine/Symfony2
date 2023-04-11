/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
/**
 *
 * @author mr.rhimi
 */
public class GeolocationExample {
    public  String GetLocationfromip() throws IOException {
        String apiKey = "ff7dfe0fa7174630bb3b2f8e4222dbdd";
       GetMyip ip =new GetMyip();
       
        //String ipAddress = "197.240.208.67";
        String ipAddress =ip.Myip();
        String url = "https://ipgeolocation.abstractapi.com/v1/?api_key=" + apiKey + "&ip_address=" + ipAddress;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson gson = new Gson();
        GeolocationResponse geolocationResponse = gson.fromJson(response.toString(), GeolocationResponse.class);
        String city = geolocationResponse.getCity();

        return geolocationResponse.getCity() ;
    }
}

class GeolocationResponse {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
