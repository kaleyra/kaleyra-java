/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.group;

import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupResponse {
    private JSONObject json;
    private String status,message,code,groupID;
    private SMSMessageResponse[] smsMessageResponse = null;

    /**
     * Constructor for populating response object
     */
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
                smsMessageResponse[i] = new SMSMessageResponse(jsonObject,Integer.toString(i));
            }
        }catch(Exception e){

        }
    }

    /**
     * Method to return the complete API call response
     * @return JSONObject json
     */
    public JSONObject toJson() {
        return(this.json);
    }

    /**
     * Method to return all "data" objects from API call response
     * @return SMSMessageResponse[] object smsMessageResponse
     */
    public SMSMessageResponse[] getSMSMessageResponses(){
        return this.smsMessageResponse;
    }

    /**
     * Method to return "Status" from API call response
     * @return String status
     */
    public String getStatusMessage() {
        return this.status;
    }

    /**
     * Method to return "Message" from API call response
     * @return String message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Method to return "Code" from API call response
     * @return String code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to return "Group ID" from API call response
     * @return String groupID
     */
    public String getGroupID() {
        return groupID;
    }
}
