package com.kaleyra.messaging.api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static com.kaleyra.messaging.api.Konstants.baseURL;

public class SMSGroupResponse {
    public static JSONObject json;
    StringBuilder sb = new StringBuilder();
    public SMSGroupResponse(String urlParameters){
        String url = baseURL + "?" + urlParameters;
        try {
            URL finalURL = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(finalURL.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = sb.toString();
        try {
            json = new JSONObject(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void toJson() {
        System.out.println(json.toString());
    }
    public void getStatusMessage() {
        try {
            System.out.println("Status : " + json.get("status"));
        } catch (Exception e) {
            System.out.println("No Status Message present");
        }
    }

    public void getMessage() {
        try {
            System.out.println("Message : " + json.get("message"));
        } catch (Exception e) {
            System.out.println("No Message present");
        }
    }
    public void getData(){
        try{
            System.out.println("Data : "+json.get("data"));
        }catch(Exception e){
            System.out.println("No Data present");
        }
    }
}
