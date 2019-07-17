/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.sms;

import com.kaleyra.messaging.api.utilities.Klient;
import org.json.JSONObject;
import static com.kaleyra.messaging.api.utilities.Konstants.*;


public class SMSMessageRequest extends MessageRequest {
    private String message;
    private long number;
    private String groupID,dlrURL,custom,unicode,flash,port;

    public SMSMessageRequest(){}

    /**
     * Constructor to initialize values for deleting and modifying scheduled SMS
     */
    public SMSMessageRequest(String groupID){
        this.groupID = groupID;
    }

    /**
     * Constructor to initialize values for sending SMS and scheduling SMS
     */
    public SMSMessageRequest(long number,String message,String dlrURL,String custom,String unicode,String flash,String port) {
        this.message = message;
        this.number = number;
        this.dlrURL = dlrURL;
        this.custom = custom;
        this.unicode = unicode;
        this.flash = flash;
        this.port = port;
    }

    /**
     * Method to return mobile number for validation
     * @return long number
     */
    public long getNumber() {
        return this.number;
    }

    /**
     * Method to return message for validation
     * @return String message
     */
    public  String getMessage() {
        return this.message;
    }

    /**
     * This method enables you to send an SMS
     * @return SMSMessageResponse object smsMessageResponse
     */
    @Override
    public SMSMessageResponse sendSMS() {
        StringBuilder urlParameters  =  new StringBuilder("method=sms&message=" + message + "&sender=" + senderID + "&to=" + number + "&api_key=" + apiKey);
        if(dlrURL != null)
            urlParameters.append("&dlrURL="+dlrURL);
        if(custom != null)
            urlParameters.append("&custom="+custom);
        if(unicode != null)
            urlParameters.append("&unicode="+unicode);
        if(flash != null)
            urlParameters.append("&flash="+flash);
        if(port != null)
            urlParameters.append("&port="+port);
        Klient klient  = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * This method enables you to schedule an SMS to a single number anytime
     * @return SMSMessageResponse object smsMessageResponse
     */
    @Override
    public SMSMessageResponse scheduleSMS(String date) {
        StringBuilder urlParameters = new StringBuilder("api_key=" + apiKey + "&method=sms&message=" + message + "&to=" + number + "&sender=" + senderID + "&time=" + date);
        if(dlrURL != null)
            urlParameters.append("&dlrURL="+dlrURL);
        if(custom != null)
            urlParameters.append("&custom="+custom);
        if(unicode != null)
            urlParameters.append("&unicode="+unicode);
        if(flash != null)
            urlParameters.append("&flash="+flash);
        if(port != null)
            urlParameters.append("&port="+port);
        Klient klient  = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * This method enables you to modify a scheduled SMS
     * @return SMSMessageResponse object smsMessageResponse
     */
    @Override
    public SMSMessageResponse modifySchedule(String date) {
        String urlParameters  =  "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&time=" + date + "&task=modify";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * This method enables you to delete a scheduled SMS
     * @return SMSMessageResponse object smsMessageResponse
     */
    @Override
    public SMSMessageResponse deleteSchedule (){
        String urlParameters  =  "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&task=delete";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * Through this method, user will be able to check the status of SMS sent using message ID
     * @return SMSMessageResponse object smsMessageResponse
     */
    @Override
    public SMSMessageResponse checkSMSStatus(){
        String urlParameters  =  "api_key=" + apiKey + "&method=sms.status&id=" + groupID + "&credits=1";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * Through this method, user will be able to check the available credits in his/her account
     * @return SMSMessageResponse object smsMessageResponse
     */
    @Override
    public SMSMessageResponse checkCredits(){
        String urlParameters  =  "api_key=" + apiKey +"&method=account.credits";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * Through this method, user will be able to check the credits usage in his/her account in a particular date range
     * @return SMSMessageResponse object smsMessageResponse
     */
    @Override
    public SMSMessageResponse checkCreditUsage(String fromDate,String toDate){
        String urlParameters  =  "api_key=" + apiKey +"&method=sms.usagecredit&from=" + fromDate + "&to=" + toDate + "&format=json";
        Klient klient  = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

}



