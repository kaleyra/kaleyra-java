/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.sms;

import org.json.JSONObject;

public class SMSMessageResponse extends KResponse {
    private String dlrStatus,id, customID, customID1, customID2, mobile,credits;
    public SMSMessageResponse() {

    }

    /**
     * Constructor for populating response object
     */
    public SMSMessageResponse(JSONObject json) {
        super(json);
        try {
            id = json.getJSONArray("data").getJSONObject(0).getString("id");
            if (id.equals(""))
                id = null;
        } catch (Exception e) {
            id = "ID not found";
        }
        try {
            customID = json.getJSONArray("data").getJSONObject(0).getString("customID");
            if (customID.equals(""))
                customID = null;
        } catch (Exception e) {
            customID = "Custom ID not found";
        }
        try {
            customID1 = json.getJSONArray("data").getJSONObject(0).getString("customid1");
            if (customID1.equals(""))
                customID1 = null;
        } catch (Exception e) {
            customID1 = "Custom ID 1 not found";
        }
        try {
            customID2 = json.getJSONArray("data").getJSONObject(0).getString("customid2");
            if (customID2.equals(""))
                customID2 = null;
        } catch (Exception e) {
            customID2 = "Custom ID 2 not found";
        }
        try {
            mobile = json.getJSONArray("data").getJSONObject(0).getString("mobile");
            if (mobile.equals(""))
                mobile = null;
        } catch (Exception e) {
            mobile = "Mobile not found";
        }
        try {
            dlrStatus = json.getJSONArray("data").getJSONObject(0).getString("status");
            if (dlrStatus.equals(""))
                dlrStatus = null;
        } catch (Exception e) {
            dlrStatus = "Status Message not found";
        }
        try {
            statusCode = json.getString("code");
            if (statusCode.equals(""))
                statusCode = null;
        } catch (Exception e) {
            statusCode = "Status Code not found";
        }
        try {
            credits = json.getJSONObject("data").getString("credits");
            if (credits.equals(""))
                credits = null;
        } catch (Exception e) {
            credits = "Credits not found";
        }
    }

    /**
     * Constructor for populating response object for group response
     */
    public SMSMessageResponse(JSONObject json,String arrayElement) {
        super(json);
        try {
            id = json.getJSONObject(arrayElement).getString("id");
            if(id.equals(""))
                id = null;
        } catch (Exception e) {
            id = "ID not found";
        }
        try {
            customID = json.getJSONObject(arrayElement).getString("customID");
            if(customID.equals(""))
                customID = null;
        } catch (Exception e) {
            customID = "Custom ID not found";
        }
        try {
            customID1 = json.getJSONObject(arrayElement).getString("customid1");
            if(customID1.equals(""))
                customID1 = null;
        } catch (Exception e) {
            customID1 = "Custom ID 1 not found";
        }
        try {
            customID2 = json.getJSONObject(arrayElement).getString("customid2");
            if(customID2.equals(""))
                customID2 = null;
        } catch (Exception e) {
            customID2 = "Custom ID 1 not found";
        }
        try {
            mobile = json.getJSONObject(arrayElement).getString("mobile");
            if(mobile.equals(""))
                mobile = null;
        } catch (Exception e) {
            mobile = "Mobile not found";
        }
        try {
            dlrStatus = json.getJSONObject(arrayElement).getString("status");
            if(dlrStatus.equals(""))
                dlrStatus = null;
        } catch (Exception e) {
            dlrStatus = "Status Message not found";
        }
    }
    public String getID() { return this.id; }
    public String getCustomid() { return this.customID; }
    public String getCustomid1() { return this.customID1; }
    public String getCustomid2() { return this.customID2;}
    public String getMobile() { return this.mobile;}
    public String getDlrStatus() { return this.dlrStatus; }
    public String getCredits() { return this.credits; }
}
