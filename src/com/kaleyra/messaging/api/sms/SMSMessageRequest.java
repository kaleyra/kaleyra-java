/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.api.sms;

import com.kaleyra.messaging.api.utilities.Klient;
import org.json.JSONObject;
import static com.kaleyra.messaging.api.utilities.Konstants.*;

//Class to handle all SMS Message Requests
public class SMSMessageRequest extends MessageRequest {
    public static String message;
    public static long number;
    private static String groupID,dlrURL,custom,unicode,flash,port;

    public SMSMessageRequest(){}
    public SMSMessageRequest(String groupID){ //for deleting and modifying scheduled SMS
        this.groupID = groupID;
    }
    public SMSMessageRequest(long number,String message,String dlrURL,String custom,String unicode,String flash,String port) { //for sending SMS and scheduling SMS
        this.message = message;
        this.number = number;
        this.dlrURL = dlrURL;
        this.custom = custom;
        this.unicode = unicode;
        this.flash = flash;
        this.port = port;
    }

    //Function to send SMS
    @Override
    public SMSMessageResponse sendSMS() {
        StringBuilder urlParameters  =  new StringBuilder("method = sms&message = " + message + "&sender = " + senderID + "&to = " + number + "&api_key = " + apiKey);
        if(dlrURL != null)
            urlParameters.append("&dlrURL = "+dlrURL);
        if(custom != null)
            urlParameters.append("&custom = "+custom);
        if(unicode != null)
            urlParameters.append("&unicode = "+unicode);
        if(flash != null)
            urlParameters.append("&flash = "+flash);
        if(port != null)
            urlParameters.append("&port = "+port);
        Klient klient  = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    //Function to schedule SMS
    @Override
    public SMSMessageResponse scheduleSMS(String date) {
        StringBuilder urlParameters  =  new StringBuilder("api_key = " + apiKey + "&method = sms&message = " + message + "&to = " + number + "&sender = " + senderID + "&time = " + date);
        if(dlrURL != null)
            urlParameters.append("&dlrURL = "+dlrURL);
        if(custom != null)
            urlParameters.append("&custom = "+custom);
        if(unicode != null)
            urlParameters.append("&unicode = "+unicode);
        if(flash != null)
            urlParameters.append("&flash = "+flash);
        if(port != null)
            urlParameters.append("&port = "+port);
        Klient klient  = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    //Function to modify scheduled SMS
    @Override
    public SMSMessageResponse modifySchedule(String date) {
        String urlParameters  =  "api_key = " + apiKey + "&method = sms.schedule&groupid = " + groupID + "&time = " + date + "&task = modify";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    //Function to delete scheduled SMS
    @Override
    public SMSMessageResponse deleteSchedule (){
        String urlParameters  =  "api_key = " + apiKey + "&method = sms.schedule&groupid = " + groupID + "&task = delete";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    //Function to check SMS status
    @Override
    public SMSMessageResponse checkSMSStatus(){
        String urlParameters  =  "api_key = " + apiKey + "&method = sms.status&id = " + groupID + "&credits = 1";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    //Function to check number of credits left in account
    @Override
    public SMSMessageResponse checkCredits(){
        String urlParameters  =  "api_key = " + apiKey +"&method = account.credits";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    //Function to check credit usage from specific date to specific date
    @Override
    public SMSMessageResponse checkCreditUsage(String fromDate,String toDate){
        String urlParameters  =  "api_key = " + apiKey +"&method = sms.usagecredit&from = " + fromDate + "&to = " + toDate + "&format = json";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

}



