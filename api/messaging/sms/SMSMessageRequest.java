/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package api.messaging.sms;

import api.messaging.KRequest;
import org.json.JSONObject;
import utilities.Klient;
import utilities.Validation;
import static utilities.Konstants.*;


public class SMSMessageRequest extends KRequest {
    private String groupID, dlrURL, custom, unicode, flash, port, dateAndTime, dateFormat;

    public SMSMessageRequest() {
    }

    /**
     * Constructor to initialize values for deleting and modifying scheduled SMS
     */
    public SMSMessageRequest(String groupID) {
        this.groupID = groupID;
    }


    /**
     * Constructor to initialize values for deleting and modifying scheduled SMS
     */
    public SMSMessageRequest(String groupID, String dateAndTime, String dateFormat) {
        this.groupID = groupID;
        this.dateAndTime = dateAndTime;
        this.dateFormat = dateFormat;
    }

    /**
     * Constructor to initialize values for sending SMS and scheduling SMS
     */
    public SMSMessageRequest(long number, String message, String dlrURL, String custom, String unicode, String flash, String port) {
        this.message = message;
        this.number = number;
        this.dlrURL = dlrURL;
        this.custom = custom;
        this.unicode = unicode;
        this.flash = flash;
        this.port = port;
    }

    public void setSchedule(String dateAndTime,String dateFormat){
        this.dateAndTime = dateAndTime;
        this.dateFormat = dateFormat;
    }
    /**
     * Method to return mobile number for validation
     *
     * @return long number
     */
    public long getNumber() {
        return this.number;
    }

    /**
     * Method to return message for validation
     *
     * @return String message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * This method enables you to send an SMS
     *
     * @return SMSMessageResponse object smsMessageResponse
     */
    public SMSMessageResponse send() {
        StringBuilder urlParameters = new StringBuilder("method=sms&message=" + message + "&sender=" + senderID + "&to=" + number + "&api_key=" + apiKey);
        if (dlrURL != null)
            urlParameters.append("&dlrURL=" + dlrURL);
        if (custom != null)
            urlParameters.append("&custom=" + custom);
        if (unicode != null)
            urlParameters.append("&unicode=" + unicode);
        if (flash != null)
            urlParameters.append("&flash=" + flash);
        if (port != null)
            urlParameters.append("&port=" + port);
        Klient klient;
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
        Validation validation = new Validation();
        if (validation.validate(this.number, this.message) == 1) {
            klient = new Klient(urlParameters.toString());
            JSONObject json = klient.getResponse();
            smsMessageResponse = new SMSMessageResponse(json);
        }
        return smsMessageResponse;
    }

    /**
     * This method enables you to schedule an SMS to a single number anytime
     *
     * @return SMSMessageResponse object smsMessageResponse
     */
    public SMSMessageResponse scheduleSMS() {
        Validation validation = new Validation();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
        String date = validation.validate(this.dateAndTime, this.dateFormat);
        if(date.equals("Past")) {
            System.out.println("Invalid Date and/or time");
            return smsMessageResponse;
        }
        else if(date.equals("Invalid")) {
            System.out.println("Time difference should be greater than 5 minutes and less than 3 months from the current time");
        }
        else if(validation.validate(number,message)==1) {
            StringBuilder urlParameters = new StringBuilder("api_key=" + apiKey + "&method=sms&message=" + message + "&to=" + number + "&sender=" + senderID + "&time=" + date);
            if (dlrURL != null)
                urlParameters.append("&dlrURL=" + dlrURL);
            if (custom != null)
                urlParameters.append("&custom=" + custom);
            if (unicode != null)
                urlParameters.append("&unicode=" + unicode);
            if (flash != null)
                urlParameters.append("&flash=" + flash);
            if (port != null)
                urlParameters.append("&port=" + port);
            Klient klient = new Klient(urlParameters.toString());
            JSONObject json = klient.getResponse();
            smsMessageResponse = new SMSMessageResponse(json);
        }
        return smsMessageResponse;
    }

    /**
     * This method enables you to modify a scheduled SMS
     *
     * @return SMSMessageResponse object smsMessageResponse
     */
    public SMSMessageResponse editSchedule() {
        Validation validation = new Validation();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
        String date = validation.validate(this.dateAndTime, this.dateFormat);
        if(date.equals("Past")) {
            System.out.println("Invalid Date and/or time");
        }
        else if(date.equals("Invalid")) {
            System.out.println("Time difference should be greater than 5 minutes and less than 3 months from the current time");
        }
        else {
            String urlParameters = "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&time=" + date + "&task=modify";
            Klient klient = new Klient(urlParameters);
            JSONObject json = klient.getResponse();
            smsMessageResponse = new SMSMessageResponse(json);
        }
        return smsMessageResponse;
    }

    /**
     * This method enables you to delete a scheduled SMS
     *
     * @return SMSMessageResponse object smsMessageResponse
     */
    public SMSMessageResponse deleteSchedule() {
        String urlParameters = "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&task=delete";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * Through this method, user will be able to check the status of SMS sent using message ID
     *
     * @return SMSMessageResponse object smsMessageResponse
     */
    public SMSMessageResponse checkSMSStatus() {
        String urlParameters = "api_key=" + apiKey + "&method=sms.status&id=" + groupID + "&credits=1";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * Through this method, user will be able to check the available credits in his/her account
     *
     * @return SMSMessageResponse object smsMessageResponse
     */
    public SMSMessageResponse checkCredits() {
        String urlParameters = "api_key=" + apiKey + "&method=account.credits";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }

    /**
     * Through this method, user will be able to check the credits usage in his/her account in a particular date range
     *
     * @return SMSMessageResponse object smsMessageResponse
     */
    public SMSMessageResponse checkCreditUsage(String fromDate, String toDate) {
        String urlParameters = "api_key=" + apiKey + "&method=sms.usagecredit&from=" + fromDate + "&to=" + toDate + "&format=json";
        Klient klient = new Klient(urlParameters);
        JSONObject json = klient.getResponse();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse(json);
        return smsMessageResponse;
    }
}



