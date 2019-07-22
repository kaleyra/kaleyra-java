/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.txtly;

import org.json.JSONArray;
import org.json.JSONObject;

public class TxtlyReport {
    private JSONObject json;
    private String  statusMessage,message;
    private Txtlys[] txtlys;
    private Pagination pagination;

    /**
     * Constructor for populating response object
     */
    public TxtlyReport(JSONObject json){
        try{
            this.json = json;
        }catch (Exception e){
            System.out.println("Response not received");
        }
        try{
            statusMessage = json.getString("status");
            if(statusMessage.equals(""))
                statusMessage = null;
        } catch (Exception e) {
            statusMessage = "Status message not found";
        }
        try{
            message = json.getString("message");
            if(message.equals(""))
                message = null;
        }catch (Exception e) {
            message = "Message not found";
        }
        JSONArray jsonArray = null;
        int size = 0;
        try {
            jsonArray = json.getJSONObject("data").getJSONArray("txtlys");
            size = jsonArray.length();
        }catch(Exception e){

        }
        JSONObject jsonObject = null;
        try{
            jsonObject = json.getJSONObject("data").getJSONObject("pagination");
        }catch(Exception e){

        }
        pagination = new Pagination(jsonObject);
        txtlys = new Txtlys[size];
        for(int i=0;i<size;i++)
            txtlys[i] = new Txtlys(jsonArray,i);
    }

    public class Txtlys{
        private String shortURL, created, linkID, title, txtlyToken, longURL, advanced, linkType, callBack, metaValue, views, lastViewed, status;
        private Integer serial;

        /**
         * Constructor for populating array of txtly objects
         */
        public Txtlys(JSONArray jsonArray,int i){
            try {
                linkID = jsonArray.getJSONObject(i).getString("link_id");
                if(linkID.equals(""))
                    linkID = null;
            } catch (Exception e) {
                linkID = "Link ID not found";
            }
            try {
                title = jsonArray.getJSONObject(i).getString("title");
                if(title.equals(""))
                    title = null;
            } catch (Exception e) {
                title  = "Title not found";
            }
            try {
                txtlyToken = jsonArray.getJSONObject(i).getString("token");
                if(txtlyToken.equals(""))
                    txtlyToken= null;
            } catch (Exception e) {
                txtlyToken = "Txtly Token not found";
            }
            try {
                longURL = jsonArray.getJSONObject(i).getString("long_url");
                if(longURL.equals(""))
                    longURL = null;
            } catch (Exception e) {
                longURL = "Long URL not found";
            }
            try {
                advanced  =  jsonArray.getJSONObject(i).getString("advanced");
                if(advanced.equals(""))
                    advanced = null;
            } catch (Exception e) {
                advanced = "Advanced not found";
            }
            try {
                linkType  =  jsonArray.getJSONObject(i).getString("link_type");
                if(linkType.equals(""))
                    linkType = null;
            } catch (Exception e) {
                linkType = "Link Type not found";
            }
            try {
                callBack  =  jsonArray.getJSONObject(i).getString("callback");
                if(callBack.equals(""))
                    callBack = null;
            } catch (Exception e) {
                callBack = "Call Back not found";
            }
            try {
                metaValue  =  jsonArray.getJSONObject(i).getString("meta_value");
                if(metaValue.equals(""))
                    metaValue = null;
            } catch (Exception e) {
                metaValue = "Meta Value not found";
            }
            try {
                views  =  jsonArray.getJSONObject(i).getString("views");
                if(views.equals(""))
                    views = null;
            } catch (Exception e) {
                views = "Views not found";
            }
            try {
                lastViewed  =  jsonArray.getJSONObject(i).getString("last_viewed");
                if(lastViewed.equals(""))
                    lastViewed = null;
            } catch (Exception e) {
                lastViewed = "Last Viewed not found";
            }
            try {
                status  =  jsonArray.getJSONObject(i).getString("status");
                if(status.equals(""))
                    status = null;
            } catch (Exception e) {
                status = "Status not found";
            }
            try {
                created  =  jsonArray.getJSONObject(i).getString("created");
                if(created.equals(""))
                    created = null;
            } catch (Exception e) {
                created  = "Created not found";
            }
            try {
                serial  =  jsonArray.getJSONObject(i).getInt("serial");
                if(serial.toString().equals(""))
                    serial = null;
            } catch (Exception e) {
                serial = 0;
            }
            try {
                shortURL = jsonArray.getJSONObject(i).getString("short_url");
                if(shortURL.equals(""))
                    shortURL = null;
            } catch (Exception e) {
                shortURL = "Short URL not found";
            }
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
            return this.linkType;
        }
        public String getCallBack() {
            return this.callBack;
        }
        public String getMetaValue() {
            return this.metaValue;
        }
        public String getViews() {
            return this.views;
        }
        public String getLastViewed() {
            return this.lastViewed;
        }
        public String getTxtlyStatus() {
            return this.status;
        }
        public String getCreated() {
            return this.created;
        }
        public int getSerial() {
            return this.serial;
        }
        public String getShortURL() {
            return this.shortURL;
        }
    }

    public class Pagination{
        private Integer now,page,limit,limitStart;
        private boolean next;

        /**
         * Constructor for populating pagination object
         */
        public Pagination(JSONObject json){
            try {
                now = json.getInt("now");
                if(now.toString().equals(""))
                    now = null;
            } catch (Exception e) {
                now = 0;
            }
            try {
                next = json.getBoolean("next");
            } catch (Exception e) {
                next = false;
            }
            try {
                page = json.getInt("page");
                if(page.toString().equals(""))
                    page = null;
            } catch (Exception e) {
                page = 0;
            }
            try {
                limit = json.getInt("limit");
                if(limit.toString().equals(""))
                    limit = null;
            } catch (Exception e) {
                limit = 0;
            }
            try {
                limitStart = json.getInt("limitstart");
                if(limitStart.toString().equals(""))
                    limitStart = null;
            } catch (Exception e) {
                limitStart = 0;
            }
        }
        public int getNow() {
            return this.now;
        }
        public boolean getNext() {
            return this.next;
        }
        public int getPage() {
            return this.page;
        }
        public int getLimit() {
            return this.limit;
        }
        public int getLimitStart() {
            return this.limitStart;
        }
    }
    public JSONObject toJSON() {
        return this.json;
    }
    public Txtlys[] getTxtlyResponses(){
        return this.txtlys;
    }
    public String getStatusMessage() {
        return this.statusMessage;
    }
    public String getMessage() {
        return this.message;
    }
    public Pagination getPagination() {
        return this.pagination;
    }

}
