/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.api.group;

import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupResponse {
    private JSONObject json;
    private String status,message,code,groupID;
    private SMSMessageResponse[] smsMessageResponse = null;
    public GroupResponse(JSONObject json){
        this.json = json;
        try {
            this.status = json.getString("status");
        } catch (JSONException e) {
            status = null;
        }
        try {
            message = json.getString("message");
        } catch (Exception e) {
            message = null;
        }
        try {
            code = json.getString("code");
        } catch (Exception e) {
            code = null;
        }
        try {
            groupID = json.getString("group_id");
        } catch (Exception e) {
            groupID = null;
        }
        int sizeOfArray;
        try {
            JSONObject jsonObject = json.getJSONObject("data");
            sizeOfArray = jsonObject.length();
            smsMessageResponse = new SMSMessageResponse[sizeOfArray];
            for (int i=0;i<sizeOfArray;i++) {
                smsMessageResponse[i] = new SMSMessageResponse(jsonObject.getJSONObject(Integer.toString(i)));
            }
        }catch(Exception e){

        }
    }

    public JSONObject toJson() {
        return(this.json);
    }
    public SMSMessageResponse[] getSMSMessageResponses(){
        return this.smsMessageResponse;
    }
    public String getStatusMessage() {
        return this.status;
    }
    public String getMessage() {
        return this.message;
    }
    public String getCode() {
        return code;
    }
    public String getGroupID() {
        return groupID;
    }
}
