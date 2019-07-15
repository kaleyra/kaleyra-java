/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.api.txtly;

import org.json.JSONObject;

//Class to return responses for txtly requests
public class TxtlyResponse {
    private JSONObject json;
    private String statusMessage, shortURL, created, message, token, txtly, id, linkID, title, txtlyToken, longURL, advanced, linkType, callBack, metaValue, views, lastViewed, status;
    private int serial, now, page, limit, limitStart;
    private boolean next;

    //Constructor
    public TxtlyResponse(JSONObject json) {
        this.json  =  json;
        try {
            statusMessage  =  json.get("status").toString();
        } catch (Exception e) {
            statusMessage  =  null;
        }
        try {
            message  =  json.get("message").toString();
        } catch (Exception e) {
            message  =  null;
        }
        try {
            token  =  json.get("token").toString();
        } catch (Exception e) {
            token  =  null;
        }
        try {
            txtly  =  json.get("txtly").toString();
        } catch (Exception e) {
            txtly  =  null;
        }
        try {
            id  =  json.get("id").toString();
        } catch (Exception e) {
            id  =  null;
        }
        try {
            linkID  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("link_id");
        } catch (Exception e) {
            linkID  =  null;
        }
        try {
            title  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("title");
        } catch (Exception e) {
            title  =  null;
        }
        try {
            txtlyToken  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("token");
        } catch (Exception e) {
            txtlyToken  =  null;
        }
        try {
            longURL  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("long_url");
        } catch (Exception e) {
            longURL  =  null;
        }
        try {
            advanced  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("advanced");
        } catch (Exception e) {
            advanced  =  null;
        }
        try {
            linkType  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("link_type");
        } catch (Exception e) {
            linkType  =  null;
        }
        try {
            callBack  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("callback");
        } catch (Exception e) {
            callBack  =  null;
        }
        try {
            metaValue  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("meta_value");
        } catch (Exception e) {
            metaValue  =  null;
        }
        try {
            views  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("views");
        } catch (Exception e) {
            views  =  null;
        }
        try {
            lastViewed  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("last_viewed");
        } catch (Exception e) {
            lastViewed  =  null;
        }
        try {
            status  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("status");
        } catch (Exception e) {
            status  =  null;
        }
        try {
            created  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("created");
        } catch (Exception e) {
            created  =  null;
        }
        try {
            serial  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getInt("serial");
        } catch (Exception e) {
            serial  =  0;
        }
        try {
            shortURL  =  json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("short_url");
        } catch (Exception e) {
            shortURL  =  null;
        }
        try {
            now  =  json.getJSONObject("data").getJSONObject("pagination").getInt("now");
        } catch (Exception e) {
            now  =  0;
        }
        try {
            next  =  json.getJSONObject("data").getJSONObject("pagination").getBoolean("next");
        } catch (Exception e) {
            next  =  false;
        }
        try {
            page  =  json.getJSONObject("data").getJSONObject("pagination").getInt("page");
        } catch (Exception e) {
            page  =  0;
        }
        try {
            limit  =  json.getJSONObject("data").getJSONObject("pagination").getInt("limit");
        } catch (Exception e) {
            limit  =  0;
        }
        try {
            limitStart  =  json.getJSONObject("data").getJSONObject("pagination").getInt("limitstart");
        } catch (Exception e) {
            limitStart  =  0;
        }
    }

    public JSONObject toJson() {
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
    public String getTxtly() {
        return this.txtly;
    }
    public String getID() {
        return this.id;
    }
    public String getLinkID() {
        return this.linkID;
    }
    public String getTitle() {
        return this.title;
    }
    public String getTxtlyToken() {
        return this.txtlyToken;
    }
    public String getLongURL() {
        return this.longURL;
    }
    public String getAdvanced() {
        return this.advanced;
    }
    public String getLinkType() {
        return linkType;
    }
    public String getCallBack() {
        return callBack;
    }
    public String getMetaValue() {
        return metaValue;
    }
    public String getViews() {
        return views;
    }
    public String getLastViewed() {
        return lastViewed;
    }
    public String getTxtlyStatus() {
        return status;
    }
    public String getCreated() {
        return created;
    }
    public int getSerial() {
        return serial;
    }
    public String getShortURL() {
        return shortURL;
    }
    public int getNow() {
        return now;
    }
    public boolean getNext() {
        return next;
    }
    public int getPage() {
        return this.page;
    }
    public int getLimit() {
        return limit;
    }
    public int getLimitStart() {
        return limitStart;
    }
}
