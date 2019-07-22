/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.txtly;

import org.json.JSONObject;

public class TxtlyResponse {
    private JSONObject json;
    private String txtly,statusMessage,message,token;
    private Integer id;

    /**
     * Constructor for populating response object
     */
    public TxtlyResponse(JSONObject json) {
        try{
            this.json = json;
        }catch (Exception e){
            System.out.println("Response not received");
        }
        try{
            statusMessage = json.getString("status");
            if(statusMessage.equals(""))
                statusMessage = null;
        }catch (Exception e) {
            statusMessage = "Status message not found";
        }
        try{
            message = json.getString("message");
            if(message.equals(""))
                message = null;
        }catch (Exception e) {
            message = "Message not found";
        }
        try {
            token = json.getString("token");
            if(token.equals(""))
                token = null;
        } catch (Exception e) {
            token = "Token not found";
        }
        try {
            id = json.getInt("id");
            if(id.toString().equals(""))
                id = null;
        } catch (Exception e) {
            id = 0;
        }
        try {
            txtly = json.getString("txtly");
            if(txtly.equals(""))
                txtly = null;
        } catch (Exception e) {
            txtly = "Txtly not found";
        }
    }
    public JSONObject toJSON() {
        return(this.json);
    }
    public String getStatusMessage() {
        return this.statusMessage;
    }
    public String getMessage() {
        return this.message;
    }
    public String getToken() {
        return this.token;
    }
    public int getID() {
        return this.id;
    }
    public String getTxtly() {
        return this.txtly;
    }
}
