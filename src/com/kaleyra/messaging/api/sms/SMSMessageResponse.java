/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.sms;

import org.json.JSONObject;

public class SMSMessageResponse extends MessageResponse {
    private String id, customid, customID1, customID2, mobile, status;
    JSONObject json;

    public SMSMessageResponse() {

    }

    /**
     * Constructor for populating response object
     */
    public SMSMessageResponse(JSONObject json) {
        super(json);
        this.json = json;
        try {
            id = json.getJSONArray("data").getJSONObject(0).getString("id");
        } catch (Exception e) {
            id = null;
        }
        try {
            customid = json.getJSONArray("data").getJSONObject(0).getString("customid");
        } catch (Exception e) {
            customid = null;
        }
        try {
            customID1 = json.getJSONArray("data").getJSONObject(0).getString("customid1");
        } catch (Exception e) {
            customID1 = null;
        }
        try {
            customID2 = json.getJSONArray("data").getJSONObject(0).getString("customid2");
        } catch (Exception e) {
            customID2 = null;
        }
        try {
            mobile = json.getJSONArray("data").getJSONObject(0).getString("mobile");
        } catch (Exception e) {
            mobile = null;
        }
        try {
            status = json.getJSONArray("data").getJSONObject(0).getString("status");
        } catch (Exception e) {
            status = null;
        }
    }

    /**
     * Constructor for populating response object for group response
     */
    public SMSMessageResponse(JSONObject json,String arrayElement) {
        super(json);
        this.json = json;
        try {
            id = json.getJSONObject(arrayElement).getString("id");
        } catch (Exception e) {
            id = null;
        }
        try {
            customid = json.getJSONObject(arrayElement).getString("customid");
        } catch (Exception e) {
            customid = null;
        }
        try {
            customID1 = json.getJSONObject(arrayElement).getString("customid1");
        } catch (Exception e) {
            customID1 = null;
        }
        try {
            customID2 = json.getJSONObject(arrayElement).getString("customid2");
        } catch (Exception e) {
            customID2 = null;
        }
        try {
            mobile = json.getJSONObject(arrayElement).getString("mobile");
        } catch (Exception e) {
            mobile = null;
        }
        try {
            status = json.getJSONObject(arrayElement).getString("status");
        } catch (Exception e) {
            status = null;
        }
    }


    /**
     * Method to return "ID" from API call response
     * @return String id
     */
    public String getID() { return this.id; }

    /**
     * Method to return "Custom ID" from API call response
     * @return String customid
     */
    public String getCustomid() { return this.customid; }

    /**
     * Method to return "Custom ID 1" from API call response
     * @return String customID1
     */
    public String getCustomid1() { return this.customID1; }

    /**
     * Method to return "Custom ID 2" from API call response
     * @return String customID2
     */
    public String getCustomid2() { return this.customID2;}

    /**
     * Method to return "Mobile" from API call response
     * @return String mobile
     */
    public String getMobile() { return this.mobile;}

    /**
     * Method to return "Status" from API call response
     * @return String status
     */
    public String getStatus() { return this.status;}
}
