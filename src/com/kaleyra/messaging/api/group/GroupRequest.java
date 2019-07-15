/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.api.group;

import com.kaleyra.messaging.api.utilities.Klient;
import org.json.JSONObject;

import static com.kaleyra.messaging.api.utilities.Konstants.*;

//Class to accept parameters for creating groups,adding contacts and sending SMS to the group
public class GroupRequest {
    private String groupName,format,fullName,emailID,message;
    private long number;
    public GroupRequest(String groupName, String format){
        this.groupName = groupName;
        this.format = format;
    }
    public GroupRequest(String groupName, String message, String format){
        this.groupName = groupName;
        this.message = message;
        this.format = format;
    }
    public GroupRequest(long number, String groupName, String fullName, String emailID, String format){
        this.number = number;
        this.groupName = groupName;
        this.fullName = fullName;
        this.emailID = emailID;
        this.format = format;
    }

    //Function to create group
    public GroupResponse createGroup(){
        StringBuilder urlParameters = new StringBuilder("api_key="+apiKey+"&method=groups.add&task=save&app=1&data[name]=" + groupName);
        if(format != null)
            urlParameters.append("&format=" + format);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        GroupResponse groupResponse = new GroupResponse(json);
        return groupResponse;
    }

    //Function to add contacts to a group
    public GroupResponse addContact(){
        StringBuilder urlParameters = new StringBuilder("api_key=" + apiKey + "&method=groups.register&number=" + number + "&name=" + groupName + "&action=add&fullname=" + fullName + "&email=" + emailID);
        if(format != null)
            urlParameters.append("&format=" + format);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        GroupResponse groupResponse = new GroupResponse(json);
        return groupResponse;
    }

    //Function to send SMS to the group
    public GroupResponse sendGroupSMS(){
        StringBuilder urlParameters = new StringBuilder("api_key=" + apiKey + "&method=groups&name=" + groupName + "&sender=" + senderID + "&message=" + message);
        if(format != null)
            urlParameters.append("&format=" + format);
        Klient klient = new Klient(urlParameters.toString());
        JSONObject json = klient.getResponse();
        GroupResponse groupResponse = new GroupResponse(json);
        return groupResponse;
    }
}
