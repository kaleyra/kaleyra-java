/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 */

package com.kaleyra.messaging.api;

import static com.kaleyra.messaging.api.Konstants.apiKey;

public class TxtlyRequest {
    private static String id,url,format,token,title,advanced,track,attach,page;
    public TxtlyRequest(String id){
        this.id=id;
    }
    public TxtlyRequest(String url,String format,String token,String title,String advanced,String track,String attach){
        this.url=url;
        this.format=format;
        this.token=token;
        this.title=title;
        this.advanced=advanced;
        this.track=track;
        this.attach=attach;
    }
    public TxtlyRequest(String format,String page){
        this.format=format;
        this.page=page;
    }
    public TxtlyResponse createTxtlyLink(){
        String urlParameters ="api_key="+apiKey+"&method=txtly.create&url="+url;
        if(format!=null)
            urlParameters+="&format="+format;
        if(token!=null)
            urlParameters+="&token="+token;
        if(title!=null)
            urlParameters+="&title="+title;
        if(advanced!=null)
            urlParameters+="&advanced="+advanced;
        if(track!=null)
            urlParameters+="&track="+track;
        if(attach!=null)
            urlParameters+="&attach="+attach;
        TxtlyResponse txtlyResponse=new TxtlyResponse(urlParameters);
        return txtlyResponse;
    }
    public TxtlyResponse extractTxtlyReports(){
        String urlParameters="api_key="+apiKey+"&method=txtly&app=1";
        if(format!=null)
            urlParameters+="&format="+format;
        if(page!=null)
            urlParameters+="&page="+page;
        TxtlyResponse txtlyResponse=new TxtlyResponse(urlParameters);
        return txtlyResponse;
    }
    public TxtlyResponse pullIndividualTxtlyLogs(){
        String urlParameters="api_key="+apiKey+"&method=txtly.logs&id="+id+"&app=1";
        TxtlyResponse txtlyResponse=new TxtlyResponse(urlParameters);
        return txtlyResponse;
    }
    public TxtlyResponse deleteTxtlyLink(){
        String urlParameters="api_key="+apiKey+"&method=txtly&task=delete&id="+id+"&app=1";
        TxtlyResponse txtlyResponse=new TxtlyResponse(urlParameters);
        return txtlyResponse;
    }
}
