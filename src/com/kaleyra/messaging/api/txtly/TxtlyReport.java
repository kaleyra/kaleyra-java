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
        this.json=json;
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
        private int serial;

        /**
         * Constructor for populating array of txtly objects
         */
        public Txtlys(JSONArray jsonArray,int i){
            try {
                linkID  =  jsonArray.getJSONObject(i).getString("link_id");
            } catch (Exception e) {
                linkID  =  null;
            }
            try {
                title  =  jsonArray.getJSONObject(i).getString("title");
            } catch (Exception e) {
                title  =  null;
            }
            try {
                txtlyToken  =  jsonArray.getJSONObject(i).getString("token");
            } catch (Exception e) {
                txtlyToken  =  null;
            }
            try {
                longURL  =  jsonArray.getJSONObject(i).getString("long_url");
            } catch (Exception e) {
                longURL  =  null;
            }
            try {
                advanced  =  jsonArray.getJSONObject(i).getString("advanced");
            } catch (Exception e) {
                advanced  =  null;
            }
            try {
                linkType  =  jsonArray.getJSONObject(i).getString("link_type");
            } catch (Exception e) {
                linkType  =  null;
            }
            try {
                callBack  =  jsonArray.getJSONObject(i).getString("callback");
            } catch (Exception e) {
                callBack  =  null;
            }
            try {
                metaValue  =  jsonArray.getJSONObject(i).getString("meta_value");
            } catch (Exception e) {
                metaValue  =  null;
            }
            try {
                views  =  jsonArray.getJSONObject(i).getString("views");
            } catch (Exception e) {
                views  =  null;
            }
            try {
                lastViewed  =  jsonArray.getJSONObject(i).getString("last_viewed");
            } catch (Exception e) {
                lastViewed  =  null;
            }
            try {
                status  =  jsonArray.getJSONObject(i).getString("status");
            } catch (Exception e) {
                status  =  null;
            }
            try {
                created  =  jsonArray.getJSONObject(i).getString("created");
            } catch (Exception e) {
                created  =  null;
            }
            try {
                serial  =  jsonArray.getJSONObject(i).getInt("serial");
            } catch (Exception e) {
                serial  =  0;
            }
            try {
                shortURL = jsonArray.getJSONObject(i).getString("short_url");
            } catch (Exception e) {
                shortURL = null;
            }
        }
        /**
         * Method to return "Link ID" from API call response
         * @return String linkID
         */
        public String getLinkID() {
            return this.linkID;
        }

        /**
         * Method to return "Title" from API call response
         * @return String title
         */
        public String getTitle() {
            return this.title;
        }

        /**
         * Method to return "Txtly Token" from API call response
         * @return String txtlyToken
         */
        public String getTxtlyToken() {
            return this.txtlyToken;
        }

        /**
         * Method to return "Long URL" from API call response
         * @return String longURL
         */
        public String getLongURL() {
            return this.longURL;
        }

        /**
         * Method to return "Advanced" from API call response
         * @return String advanced
         */
        public String getAdvanced() {
            return this.advanced;
        }

        /**
         * Method to return "Link Type" from API call response
         * @return String linkType
         */
        public String getLinkType() {
            return this.linkType;
        }

        /**
         * Method to return "Call Back" from API call response
         * @return String callBack
         */
        public String getCallBack() {
            return this.callBack;
        }

        /**
         * Method to return "Meta Value" from API call response
         * @return String metaValue
         */
        public String getMetaValue() {
            return this.metaValue;
        }

        /**
         * Method to return "Views" from API call response
         * @return String views
         */
        public String getViews() {
            return this.views;
        }

        /**
         * Method to return "Last Viewed" from API call response
         * @return String lastViewed
         */
        public String getLastViewed() {
            return this.lastViewed;
        }

        /**
         * Method to return "Status" from API call response
         * @return String status
         */
        public String getTxtlyStatus() {
            return this.status;
        }

        /**
         * Method to return "Created" from API call response
         * @return String created
         */
        public String getCreated() {
            return this.created;
        }

        /**
         * Method to return "Serial" from API call response
         * @return int serial
         */
        public int getSerial() {
            return this.serial;
        }

        /**
         * Method to return "Short URL" from API call response
         * @return String shortURL
         */
        public String getShortURL() {
            return this.shortURL;
        }
    }

    public class Pagination{
        private int now,page,limit,limitStart;
        private boolean next;

        /**
         * Constructor for populating pagination object
         */
        public Pagination(JSONObject json){
            try {
                now = json.getInt("now");
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
            } catch (Exception e) {
                page = 0;
            }
            try {
                limit = json.getInt("limit");
            } catch (Exception e) {
                limit = 0;
            }
            try {
                limitStart = json.getInt("limitstart");
            } catch (Exception e) {
                limitStart = 0;
            }
        }

        /**
         * Method to return "Now" from API call response
         * @return int now
         */
        public int getNow() {
            return this.now;
        }

        /**
         * Method to return "Next" from API call response
         * @return boolean next
         */
        public boolean getNext() {
            return this.next;
        }

        /**
         * Method to return "Page" from API call response
         * @return int page
         */
        public int getPage() {
            return this.page;
        }

        /**
         * Method to return "Limit" from API call response
         * @return int limit
         */
        public int getLimit() {
            return this.limit;
        }

        /**
         * Method to return "Limit Start" from API call response
         * @return int limitStart
         */
        public int getLimitStart() {
            return this.limitStart;
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
     * Method to return all "Txtly" objects from API call response
     * @return TxtlyResponse[] object txtlys
     */
    public Txtlys[] getTxtlyResponses(){
        return this.txtlys;
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
     * Method to return pagination
     * @return Pagination object pagination
     */
    public Pagination getPagination() {
        return this.pagination;
    }

}
