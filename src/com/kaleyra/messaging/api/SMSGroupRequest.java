/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.api;

import static com.kaleyra.messaging.api.Konstants.*;

public class SMSGroupRequest {
    public static String groupName,format,fullName,emailID,message;
    public static long number;
    public SMSGroupRequest(String groupName,String format){
        this.groupName=groupName;
        this.format=format;
    }
    public SMSGroupRequest(String groupName,String message,String format){
        this.groupName=groupName;
        this.message=message;
        this.format=format;
    }
    public SMSGroupRequest(long number,String groupName,String fullName,String emailID,String format){
        this.number=number;
        this.groupName=groupName;
        this.fullName=fullName;
        this.emailID=emailID;
        this.format=format;
    }
    public SMSGroupResponse createGroup(){
        String urlParameters = "api_key="+apiKey+"&method=groups.add&task=save&app=1&data[name]="+groupName;
        if(format!=null)
            urlParameters+="&format="+format;
        SMSGroupResponse smsGroupResponse =new SMSGroupResponse(urlParameters);
        return smsGroupResponse;
    }
    public SMSGroupResponse addContacts(){
        String urlParameters = "api_key="+apiKey+"&method=groups.register&number="+number+"&name="+groupName+"&action=add&fullname="+fullName+"&email="+emailID;
        if(format!=null)
            urlParameters+="&format="+format;
        SMSGroupResponse smsGroupResponse =new SMSGroupResponse(urlParameters);
        return smsGroupResponse;
    }
    public SMSGroupResponse sendGroupSMS(){
        String urlParameters = "api_key="+apiKey+"&method=groups&name="+groupName+"&sender="+senderID+"&message="+message;
        if(format!=null)
            urlParameters+="&format="+format;
        SMSGroupResponse smsGroupResponse =new SMSGroupResponse(urlParameters);
        return smsGroupResponse;
    }
}
