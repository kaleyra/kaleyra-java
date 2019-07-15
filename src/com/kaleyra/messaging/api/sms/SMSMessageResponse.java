/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.api.sms;

import org.json.JSONObject;

//Class to return responses for sms message requests
public class SMSMessageResponse extends MessageResponse {
    private String id,customid,customID1,customID2,mobile,status;
    public SMSMessageResponse(){

    }

    //Constructor
    public SMSMessageResponse(JSONObject json){
        this.json = json;
        try{
            id = json.getJSONArray("data").getJSONObject(0).getString("id");
        }catch(Exception e) {
            id = null;
        }
        try{
            customid  =  json.getJSONArray("data").getJSONObject(0).getString("customid");
        }catch(Exception e) {
            customid = null;
        }
        try{
            customID1 = json.getJSONArray("data").getJSONObject(0).getString("customid1");
        }catch(Exception e) {
            customID1 = null;
        }
        try{
            customID2 = json.getJSONArray("data").getJSONObject(0).getString("customid2");
        }catch(Exception e) {
            customID2 = null;
        }
        try{
            mobile = json.getJSONArray("data").getJSONObject(0).getString("mobile");
        }catch(Exception e) {
            mobile = null;
        }
        try{
            status = json.getJSONArray("data").getJSONObject(0).getString("status");
        }catch(Exception e) {
            status = null;
        }
    }
    public String getID() {
        return this.id;
    }
    public String getCustomid() { return this.customid; }
    public String getCustomid1() { return this.customID1; }
    public String getCustomid2() { return this.customID2;}
    public String getMobile() { return this.mobile;}
    public String getStatus() { return this.status;}
}
