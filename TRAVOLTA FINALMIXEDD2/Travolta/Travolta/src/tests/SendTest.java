/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tests;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author mr.rhimi
 */
public class SendTest {

    /**
     * @param args the command line arguments
     */
    public  void SendSMS() throws IOException {
URL url = new URL("https://api.boolky.net/sendSms");
HttpURLConnection http = (HttpURLConnection)url.openConnection();
http.setRequestMethod("POST");
http.setDoOutput(true);
http.setRequestProperty("Accept", "application/json");
http.setRequestProperty("Authorization", "4d409374-d35e-4bb0-99af-53f3b034dc3b");
http.setRequestProperty("Content-Type", "application/json");

String data = "{\n    \"phoneNumbers\": [\n        \"+33780966120\"\n    ],\n    \"text\": \"votre location de voiture a été réalisée avec succès.\",\n    \"saveContacts\": false\n}";

byte[] out = data.getBytes(StandardCharsets.UTF_8);

OutputStream stream = http.getOutputStream();
stream.write(out);

System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
http.disconnect();




        // TODO code application logic here
    }
    
}
