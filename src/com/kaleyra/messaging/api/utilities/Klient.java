/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.utilities;


import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import static com.kaleyra.messaging.api.utilities.Konstants.baseURL;

public class Klient {
    public static JSONObject json;
    StringBuilder sb = new StringBuilder();
    String url;

    /**
     * Constructor to append urlParameters to baseURL
     */
    public Klient(String urlParameters) {
        url = baseURL + "?" + urlParameters;
    }

    /**
     * This method executes the URL and stores the response in JSONObject json and returns json
     * @return JSONObject json
     */
    public JSONObject getResponse(){
        try {
            URL finalURL = new URL(url);
            BufferedReader in  =  new BufferedReader(
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

        }
        return json;
    }
}