/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.api.utilities;


import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

//Class for URL connection and storing response in JSON Object
public class Klient {
    public static JSONObject json;
    StringBuilder sb   =   new StringBuilder();
    String url;

    //Constructor for appending url parameters to base URL
    public Klient(String urlParameters) {
        url   =   Konstants.baseURL + "?" + urlParameters;
    }

    //URL connection and storing the response
    public JSONObject getResponse(){
        try {
            URL finalURL   =   new URL(url);
            BufferedReader in  =  new BufferedReader(
                    new InputStreamReader(finalURL.openStream()));

            String inputLine;
            while ((inputLine  =  in.readLine())  !=  null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str  =  sb.toString();
        try {
            json  =  new org.json.JSONObject(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}