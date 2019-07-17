/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.txtly;

import org.json.JSONObject;

public class TxtlyResponse {
    private JSONObject json;
    private String txtly,statusMessage,message,token;
    private int id;

    /**
     * Constructor for populating response object
     */
    public TxtlyResponse(JSONObject json) {
        this.json = json;
        try {
            statusMessage = json.getString("status");
        } catch (Exception e) {
            statusMessage = null;
        }
        try {
            message = json.getString("message");
        } catch (Exception e) {
            message = null;
        }
        try {
            token = json.getString("token");
        } catch (Exception e) {
            token = null;
        }
        try {
            id = json.getInt("id");
        } catch (Exception e) {
            id = 0;
        }
        try {
            txtly = json.getString("txtly");
        } catch (Exception e) {
            txtly = null;
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
     * Method to return "Status Message" from API call response
     * @return String statusMessage
     */
    public String getStatusMessage() {
        return this.statusMessage;
    }
    /**
     * Method to return "Message" from API call response
     * @return String message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Method to return "Token" from API call response
     * @return String token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Method to return "ID" from API call response
     * @return int id
     */
    public int getID() {
        return this.id;
    }

    /**
     * Method to return "Txtly" from API call response
     * @return String txtly
     */
    public String getTxtly() {
        return this.txtly;
    }
}
