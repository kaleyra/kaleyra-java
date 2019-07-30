/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package api.txtly;

import org.json.JSONArray;
import org.json.JSONObject;

public class TxtlyIndividualLogs {
    private String statusMessage, message;
    private JSONObject json;
    private JSONArray jsonArray;
    private Txtly txtly;
    private Pagination pagination;

    /**
     * Constructor for populating response object
     */
    public TxtlyIndividualLogs(JSONObject json) {
        try {
            this.json = json;
        } catch (Exception e) {
            System.out.println("Response not received");
        }
        try {
            statusMessage = json.getString("status");
            if (statusMessage.equals(""))
                statusMessage = null;
        } catch (Exception e) {
            statusMessage = "Status message not found";
        }
        try {
            message = json.getString("message");
            if (message.equals(""))
                message = null;
        } catch (Exception e) {
            message = "Message not found";
        }
        try {
            jsonArray = json.getJSONObject("data").getJSONArray("txtlys");
        } catch (Exception e) {

        }
        txtly = new Txtly(jsonArray);
        JSONObject jsonObject = null;
        try{
            jsonObject = json.getJSONObject("data").getJSONObject("pagination");
        }catch(Exception e){

        }
        pagination = new Pagination(jsonObject);
    }

    public class Txtly {
        private String logID, fkuserID, fkLinkID, clientIP, scheme, host, queryString, userAgent, browser, browserVersion, browserLang, browserEngine, resolution, platform, platformVersion, deviceType, deviceBrand, deviceVersion, deviceModel, touchEnabled, latitude, longitude, country, region, city, status, created, mobile;
        private Integer serial;
        /**
         * Constructor for populating txtly object
         */
        public Txtly(JSONArray jsonArray) {
            try {
                logID = jsonArray.getJSONObject(0).getString("log_id");
                if (logID.equals(""))
                    logID = null;
            } catch (Exception e) {
                logID = "Log ID not found";
            }
            try {
                fkuserID = jsonArray.getJSONObject(0).getString("fkuserid");
                if (fkuserID.equals(""))
                    fkuserID = null;
            } catch (Exception e) {
                fkuserID = "fkuserid not found";
            }
            try {
                fkLinkID = jsonArray.getJSONObject(0).getString("fk_link_id");
                if (fkLinkID.equals(""))
                    fkLinkID = null;
            } catch (Exception e) {
                fkLinkID = "fk Link ID not found";
            }
            try {
                clientIP = jsonArray.getJSONObject(0).getString("client_ip");
                if (clientIP.equals(""))
                    clientIP = null;
            } catch (Exception e) {
                clientIP = "Client IP not found";
            }
            try {
                scheme = jsonArray.getJSONObject(0).getString("scheme");
                if (scheme.equals(""))
                    scheme = null;
            } catch (Exception e) {
                scheme = "Scheme not found";
            }
            try {
                host = jsonArray.getJSONObject(0).getString("host");
                if (host.equals(""))
                    host = null;
            } catch (Exception e) {
                host = "Host not found";
            }
            try {
                queryString = jsonArray.getJSONObject(0).getString("query_string");
                if (queryString.equals(""))
                    queryString = null;
            } catch (Exception e) {
                queryString = "Query String not found";
            }
            try {
                userAgent = jsonArray.getJSONObject(0).getString("user_agent");
                if (userAgent.equals(""))
                    userAgent = null;
            } catch (Exception e) {
                userAgent = "User Agent not found";
            }
            try {
                browser = jsonArray.getJSONObject(0).getString("browser");
                if (browser.equals(""))
                    browser = null;
            } catch (Exception e) {
                browser = "Browser not found";
            }
            try {
                browserVersion = jsonArray.getJSONObject(0).getString("browser_version");
                if (browserVersion.equals(""))
                    browserVersion = null;
            } catch (Exception e) {
                browserVersion = "Browser Version not found";
            }
            try {
                browserLang = jsonArray.getJSONObject(0).getString("browser_lang");
                if (browserLang.equals(""))
                    browserLang = null;
            } catch (Exception e) {
                browserLang = "Browser Language not found";
            }
            try {
                browserEngine = jsonArray.getJSONObject(0).getString("browser_engine");
                if (browserEngine.equals(""))
                    browserEngine = null;
            } catch (Exception e) {
                browserEngine = "Browser Version not found";
            }
            try {
                resolution = jsonArray.getJSONObject(0).getString("resolution");
                if (resolution.equals(""))
                    resolution = null;
            } catch (Exception e) {
                resolution = "Log ID not found";
            }
            try {
                platform = jsonArray.getJSONObject(0).getString("platform");
                if (platform.equals(""))
                    platform = null;
            } catch (Exception e) {
                platform = "Platform not found";
            }
            try {
                platformVersion = jsonArray.getJSONObject(0).getString("platform_version");
                if (platformVersion.equals(""))
                    platformVersion = null;
            } catch (Exception e) {
                platformVersion = "Platform Version not found";
            }
            try {
                deviceType = jsonArray.getJSONObject(0).getString("device_type");
                if (deviceType.equals(""))
                    deviceType = null;
            } catch (Exception e) {
                deviceType = "Device Type not found";
            }
            try {
                deviceBrand = jsonArray.getJSONObject(0).getString("device_brand");
                if (deviceBrand.equals(""))
                    deviceBrand = null;
            } catch (Exception e) {
                deviceBrand = "Device Brand not found";
            }
            try {
                deviceVersion = jsonArray.getJSONObject(0).getString("device_version");
                if (deviceVersion.equals(""))
                    deviceVersion = null;
            } catch (Exception e) {
                deviceVersion = "Device Version not found";
            }
            try {
                deviceModel = jsonArray.getJSONObject(0).getString("device_model");
                if (deviceModel.equals(""))
                    deviceModel = null;
            } catch (Exception e) {
                deviceModel = "Device Model not found";
            }
            try {
                touchEnabled = jsonArray.getJSONObject(0).getString("touch_enabled");
                if (touchEnabled.equals(""))
                    touchEnabled = null;
            } catch (Exception e) {
                touchEnabled = "Touch Enabled not found";
            }
            try {
                latitude = jsonArray.getJSONObject(0).getString("latitude");
                if (latitude.equals(""))
                    latitude = null;
            } catch (Exception e) {
                latitude = "Latitude not found";
            }
            try {
                longitude = jsonArray.getJSONObject(0).getString("longitude");
                if (longitude.equals(""))
                    longitude = null;
            } catch (Exception e) {
                longitude = "Longitude not found";
            }
            try {
                city = jsonArray.getJSONObject(0).getString("city");
                if (city.equals(""))
                    city = null;
            } catch (Exception e) {
                city = "City not found";
            }
            try {
                status = jsonArray.getJSONObject(0).getString("status");
                if (status.equals(""))
                    status = null;
            } catch (Exception e) {
                status = "Status not found";
            }
            try {
                created = jsonArray.getJSONObject(0).getString("created");
                if (created.equals(""))
                    created = null;
            } catch (Exception e) {
                created = "Created not found";
            }
            try {
                mobile = jsonArray.getJSONObject(0).getString("mobile");
                if (mobile.equals(""))
                    mobile = null;
            } catch (Exception e) {
                mobile = "Mobile not found";
            }
            try {
                serial = jsonArray.getJSONObject(0).getInt("serial");
                if (serial.equals(""))
                    serial = null;
            } catch (Exception e) {
                serial = 0;
            }
            try {
                country = jsonArray.getJSONObject(0).getString("country");
                if (country.equals(""))
                    country = null;
            } catch (Exception e) {
                country = "Country not found";
            }
            try {
                region = jsonArray.getJSONObject(0).getString("region");
                if (region.equals(""))
                    region = null;
            } catch (Exception e) {
                region = "Region not found";
            }
        }
        public String getLogID() {
            return this.logID;
        }
        public String getFkuserID() {
            return this.fkuserID;
        }
        public String getFkLinkID() {
            return this.fkLinkID;
        }
        public String getClientIP() {
            return this.clientIP;
        }
        public String getScheme() {
            return this.scheme;
        }
        public String getHost() {
            return this.host;
        }
        public String getQueryString() {
            return this.queryString;
        }
        public String getUserAgent() {
            return this.userAgent;
        }
        public String getBrowser() {
            return this.browser;
        }
        public String getBrowserVersion() {
            return this.browserVersion;
        }
        public String getBrowserLang() {
            return this.browserLang;
        }
        public String getBrowserEngine() {
            return this.browserEngine;
        }
        public String getResolution() {
            return this.resolution;
        }
        public String getPlatform() {
            return this.platform;
        }
        public String getPlatformVersion() { return this.platformVersion; }
        public String getDeviceType() {
            return this.deviceType;
        }
        public String getDeviceBrand() {
            return this.deviceBrand;
        }
        public String getDeviceVersion() {
            return this.deviceVersion;
        }
        public String getDeviceModel() {
            return this.deviceModel;
        }
        public String getTouchEnabled() {
            return this.touchEnabled;
        }
        public String getLatitude() {
            return this.latitude;
        }
        public String getLongitude() {
            return this.longitude;
        }
        public String getCountry() {
            return this.country;
        }
        public String getRegion() {
            return this.region;
        }
        public String getCity() {
            return this.city;
        }
        public String getStatus() {
            return this.status;
        }
        public String getCreated() {
            return this.created;
        }
        public String getMobile() {
            return this.mobile;
        }
        public Integer getSerial() {
            return this.serial;
        }
    }
    public Txtly getTxtly(){
        return this.txtly;
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
