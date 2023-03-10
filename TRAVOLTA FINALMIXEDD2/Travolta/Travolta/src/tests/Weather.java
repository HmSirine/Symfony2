/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author mr.rhimi
 */
public class Weather {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException {
        
      URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Tunis&appid=a0f2555640582759910dbd717e8d1926");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    content.append(inputLine);
    System.out.println(content.append(inputLine));
}
in.close();
con.disconnect();
 
    }
    
}
