/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package api.messaging.group;

import api.messaging.KRequest;
import org.json.JSONObject;
import utilities.Klient;
import utilities.Validation;

import static utilities.Konstants.*;

public class GroupRequest extends KRequest {
    private String groupName,format,fullName,emailID;

    /**
     * Constructor to initialize values for creating group
     */
    public GroupRequest(String groupName, String format){
        this.groupName = groupName;
        this.format = format;
    }

    /**
     * Constructor to initialize values for sending SMS to group
     */
    public GroupRequest(String groupName, String message, String format){
        this.groupName = groupName;
        this.message = message;
        this.format = format;
    }

    /**
     * Constructor to initialize values for adding contacts to the group
     */
    public GroupRequest(String number, String groupName, String fullName, String emailID, String format){
        this.number = number;
        this.groupName = groupName;
        this.fullName = fullName;
        this.emailID = emailID;
        this.format = format;
    }

    /**
     * Method to return number
     * @return
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Method to return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * This method enables you to create a group of contacts from your account
     * @return GroupResponse object groupResponse
     */
    public GroupResponse create(){
        StringBuilder urlParameters = new StringBuilder("api_key="+apiKey+"&method=groups.add&task=save&app=1&data[name]=" + groupName);
        if(format != null)
            urlParameters.append("&format=" + format);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        GroupResponse groupResponse = new GroupResponse(json);
        return groupResponse;
    }

    /**
     *Through this method, you can add contacts to the SMS group you have created.
     * @return GroupResponse object groupResponse
     */
    public GroupResponse add(){
        Validation validation = new Validation();
        GroupResponse groupResponse = new GroupResponse();
        if(validation.validateNumber(number)==1) {
            StringBuilder urlParameters = new StringBuilder("api_key=" + apiKey + "&method=groups.register&number=" + number + "&name=" + groupName + "&action=add");
            if (format != null)
                urlParameters.append("&format=" + format);
            if(fullName != null)
                urlParameters.append("&fullname=" + fullName);
            if(emailID != null)
                urlParameters.append("&email=" + emailID);
            Klient klient = new Klient(urlParameters.toString());
            JSONObject json = klient.getResponse();
            groupResponse = new GroupResponse(json);
        }
        return groupResponse;
    }

    /**
     * Through this method, you'll be able to send an SMS to a group, anytime.
     * @return GroupResponse object groupResponse
     */
    public GroupResponse send(){
        Validation validation = new Validation();
        GroupResponse groupResponse = new GroupResponse();
        if(validation.validateMessage(this.message)==1) {
            StringBuilder urlParameters = new StringBuilder("api_key=" + apiKey + "&method=groups&name=" + groupName + "&sender=" + senderID + "&message=" + message);
            if (format != null)
                urlParameters.append("&format=" + format);
            Klient klient = new Klient(urlParameters.toString());
            JSONObject json = klient.getResponse();
            groupResponse = new GroupResponse(json);
        }
        return groupResponse;
    }
}
