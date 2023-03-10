/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.misc.MessageUtils.out;

/**
 *
 * @author mr.rhimi
 */
public class SendSmss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
 
    URL url = new URL("https://api.boolky.net/sendSms");
    
    HttpURLConnection con = (HttpURLConnection)url.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json");
    con.setRequestProperty("Accept", "application/json");
    con.setRequestProperty("Authorization", "4d409374-d35e-4bb0-99af-53f3b034dc3b");
    con.setDoOutput(true);
      /*
HttpURLConnection http = (HttpURLConnection)url.openConnection();
http.setRequestMethod("POST");
http.setDoOutput(true);
http.setRequestProperty("Accept", "application/json");
http.setRequestProperty("Authorization", "4d409374-d35e-4bb0-99af-53f3b034dc3b");
http.setRequestProperty("language", "EN");
http.setRequestProperty("Content-Type", "application/json");
http.setDoOutput(true);
*/
      
String jsonString = "{\"phoneNumbers\": [ \"+33780966120\" ],\"text\":\"Heloa bro\" ,\"saveContacts\":flase}";

try(OutputStream os = con.getOutputStream()) {
    byte[] input = jsonString.getBytes("utf-8");
    os.write(input, 0, input.length);			
}



try(BufferedReader br = new BufferedReader(
  new InputStreamReader(con.getInputStream(), "utf-8"))) {
    StringBuilder response = new StringBuilder();
    String responseLine = null;
    while ((responseLine = br.readLine()) != null) {
        response.append(responseLine.trim());
    }
    System.out.println(response.toString());
}
    }
    
    
}
