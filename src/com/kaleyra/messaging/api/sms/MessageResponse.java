/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.sms;

import org.json.JSONObject;

public class MessageResponse {
    JSONObject json;
    String status,message;

    /**
     * Default constructor
     */
    public MessageResponse(){

    }

    /**
     * Constructor for populating response object
     */
    public MessageResponse(JSONObject json){
        this.json=json;
        try {
           status = json.getString("status");
        } catch (Exception e) {
            status = null;
        }
        try {
            message = json.getString("message");
        } catch (Exception e) {
            message = null;
        }
    }

    /**
     * Method to return the complete API call response
     * @return JSONObject json
     */
    public JSONObject toJson() {
        return this.json;
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
}
