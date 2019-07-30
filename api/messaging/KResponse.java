/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package api.messaging;

import org.json.JSONObject;

public class KResponse {
    protected JSONObject json;
    protected String status,message,statusCode;

    /**
     * Default constructor
     */
    public KResponse(){

    }

    /**
     * Constructor for populating response object
     */
    public KResponse(JSONObject json){
        try{
            this.json=json;
        }catch(Exception e){
            System.out.println("Response not received");
        }
        try {
           status = json.getString("status");
           if(status.equals(""))
               status = null;
        } catch (Exception e) {
            status = "Status not found";
        }
        try {
            message = json.getString("message");
            if(message.equals(""))
                message = null;
        } catch (Exception e) {
            message = "Message not found";
        }
    }
    public JSONObject toJSON() {
        return this.json;
    }
    public String getMessage() {
        return this.message;
    }
    public String getStatus() { return this.status; }
    public String getStatusCode(){return this.statusCode;}
}
