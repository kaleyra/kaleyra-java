/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.sms;

import org.json.JSONObject;

//Class to display response from message requests
public class MessageResponse {
    JSONObject json;
    String status,message;
    public MessageResponse(){
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
    public JSONObject toJson() {
        return(this.json);
    }
    public String getStatusMessage() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
