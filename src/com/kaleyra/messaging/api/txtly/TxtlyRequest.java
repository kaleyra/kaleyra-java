/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.txtly;

import com.kaleyra.messaging.api.utilities.Klient;
import org.json.JSONObject;
import static com.kaleyra.messaging.api.utilities.Konstants.apiKey;


public class TxtlyRequest {
    private String url,format,token,title,advanced,track,attach,page;
    private int id;

    /**
     * Constructor to initialize values for pulling individual txtly logs and deleting txtly link
     */
    public TxtlyRequest(int id){
        this.id = id;
    }

    /**
     * Constructor to initialize values for creating txtly link
     */
    public TxtlyRequest(String url,String format,String token,String title,String advanced,String track,String attach){
        this.url = url;
        this.format = format;
        this.token = token;
        this.title = title;
        this.advanced = advanced;
        this.track = track;
        this.attach = attach;
    }

    /**
     * Constructor to initialize values for extracting txtly reports
     */
    public TxtlyRequest(String format,String page){
        this.format = format;
        this.page = page;
    }

    /**
     * This method enables you to create Txtly links which can be used within text messages so that SMS would not exceed the specified characters
     * @return TxtlyResponse object txtlyResponse
     */
    public TxtlyResponse createTxtlyLink(){
        StringBuilder urlParameters  = new StringBuilder("api_key=" + apiKey + "&method=txtly.create&url=" + url);
        if(format != null)
            urlParameters.append("&format="+ format);
        if(token != null)
            urlParameters.append("&token="+ token);
        if(title != null)
            urlParameters.append("&title="+ title);
        if(advanced != null)
            urlParameters.append("&advanced="+ advanced);
        if(track != null)
            urlParameters.append("&track="+ track);
        if(attach != null)
            urlParameters.append("&attach="+ attach);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        TxtlyResponse txtlyResponse = new TxtlyResponse(json);
        return txtlyResponse;
    }

    /**
     * Through this method, you can extract the reports of all the Txtly links that have been shortened in your account
     * @return TxtlyResponse object txtlyResponse
     */
    public TxtlyReport extractTxtlyReports(){
        StringBuilder urlParameters =  new StringBuilder("api_key=" + apiKey + "&method=txtly&app=1");
        if(format != null)
            urlParameters.append("&format=" + format);
        if(page != null)
            urlParameters.append("&page=" + page);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        TxtlyReport txtlyReport = new TxtlyReport(json);
        return txtlyReport;
    }

    /**
     * Through this method, you can pull out event logs for a particular Txtly URL
     * @return TxtlyResponse object txtlyResponse
     */
    public TxtlyIndividualLogs pullIndividualTxtlyLogs(){
        String urlParameters = "api_key="+ apiKey + "&method=txtly.logs&id=" + id + "&app=1";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        TxtlyIndividualLogs txtlyIndividualLogs = new TxtlyIndividualLogs(json);
        return txtlyIndividualLogs;
    }

    /**
     * This method enables you to delete the created Txtly web link
     * @return TxtlyResponse object txtlyResponse
     */
    public TxtlyResponse deleteTxtlyLink(){
        String urlParameters="api_key=" + apiKey + "&method=txtly&task=delete&id=" + id +"&app=1";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        TxtlyResponse txtlyResponse = new TxtlyResponse(json);
        return txtlyResponse;
    }
}
