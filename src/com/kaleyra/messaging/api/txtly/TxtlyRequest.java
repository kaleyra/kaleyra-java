/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.txtly;

import com.kaleyra.messaging.api.utilities.Klient;
import org.json.JSONObject;
import static com.kaleyra.messaging.api.utilities.Konstants.apiKey;

//Class to handle all Txtly Requests
public class TxtlyRequest {
    private static String id,url,format,token,title,advanced,track,attach,page;
    public TxtlyRequest(String id){
        this.id = id;
    }
    public TxtlyRequest(String url,String format,String token,String title,String advanced,String track,String attach){
        this.url = url;
        this.format = format;
        this.token = token;
        this.title = title;
        this.advanced = advanced;
        this.track = track;
        this.attach = attach;
    }
    public TxtlyRequest(String format,String page){
        this.format = format;
        this.page = page;
    }

    //Function to create Txtly Link
    public TxtlyResponse createTxtlyLink(){
        StringBuilder urlParameters  = new StringBuilder("api_key = " + apiKey + "&method = txtly.create&url = " + url);
        if(format != null)
            urlParameters.append("&format = "+ format);
        if(token != null)
            urlParameters.append("&token = "+ token);
        if(title != null)
            urlParameters.append("&title = "+ title);
        if(advanced != null)
            urlParameters.append("&advanced = "+ advanced);
        if(track != null)
            urlParameters.append("&track = "+ track);
        if(attach != null)
            urlParameters.append("&attach = "+ attach);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        TxtlyResponse txtlyResponse = new TxtlyResponse(json);
        return txtlyResponse;
    }

    //Function to extract Txtly Reports
    public TxtlyResponse extractTxtlyReports(){
        StringBuilder urlParameters =  new StringBuilder("api_key = " + apiKey + "&method = txtly&app = 1");
        if(format != null)
            urlParameters.append("&format = " + format);
        if(page != null)
            urlParameters.append("&page = " + page);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        TxtlyResponse txtlyResponse = new TxtlyResponse(json);
        return txtlyResponse;
    }

    //Function to pull individual Txtly Logs
    public TxtlyResponse pullIndividualTxtlyLogs(){
        String urlParameters = "api_key = "+ apiKey + "&method = txtly.logs&id = " + id + "&app = 1";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        TxtlyResponse txtlyResponse = new TxtlyResponse(json);
        return txtlyResponse;
    }

    //Function to delete TxtlyLink
    public TxtlyResponse deleteTxtlyLink(){
        String urlParameters="api_key=" + apiKey + "&method=txtly&task=delete&id=" + id +"&app=1";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        TxtlyResponse txtlyResponse = new TxtlyResponse(json);
        return txtlyResponse;
    }
}
