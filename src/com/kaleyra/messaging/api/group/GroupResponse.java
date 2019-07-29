/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.group;

import com.kaleyra.messaging.api.sms.KResponse;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupResponse extends KResponse {
    private String groupID;
    private SMSMessageResponse[] smsMessageResponse = null;

    /**
     * Constructor for populating response object
     */
    public GroupResponse(JSONObject json){
        try{
            this.json = json;
        }catch (Exception e){
            System.out.println("Response not received");
        }
        try {
            status = json.getString("status");
            if(status.equals(""))
                status = null;
        } catch (JSONException e) {
            status = "Status not found";
        }
        try {
            statusCode = json.getString("code");
            if(statusCode.equals(""))
                statusCode = null;
        } catch (Exception e) {
            statusCode = "Code not found";
        }
        try {
            groupID = json.getString("group_id");
            if(groupID.equals(""))
                groupID = null;
        } catch (Exception e) {
            groupID = "Group ID not found";
        }
        int sizeOfArray;
        try {
            JSONObject jsonObject = json.getJSONObject("data");
            sizeOfArray = jsonObject.length();
            smsMessageResponse = new SMSMessageResponse[sizeOfArray];
            for (int i=0;i<sizeOfArray;i++) {
                smsMessageResponse[i] = new SMSMessageResponse(jsonObject,Integer.toString(i));
            }
        }catch(Exception e){

        }
    }
    public SMSMessageResponse[] getSMSMessageResponses(){
        return this.smsMessageResponse;
    }
    public String getGroupID() {
        return this.groupID;
    }
}
