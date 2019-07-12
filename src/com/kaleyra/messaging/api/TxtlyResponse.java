/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 */

package com.kaleyra.messaging.api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static com.kaleyra.messaging.api.Konstants.baseURL;

public class TxtlyResponse {
    public static JSONObject json;
    StringBuilder sb = new StringBuilder();
    public TxtlyResponse(String urlParameters) {
        String url = baseURL + "?" + urlParameters;
        try {
            URL finalURL = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(finalURL.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = sb.toString();
        try {
            json = new JSONObject(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toJson() {
        System.out.println(json.toString());
    }
    public void getStatusMessage() {
        try {
            System.out.println("Status : " + json.get("status"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMessage() {
        try {
            System.out.println("Message : " + json.get("message"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getToken(){
        try {
            System.out.println("Token : " + json.get("token"));
        } catch (Exception e) {
            System.out.println("No Token present");
        }
    }
    public void getTxtly(){
        try {
            System.out.println("Txtly : " + json.get("txtly"));
        } catch (Exception e) {
            System.out.println("No Txtly present");
        }
    }
    public void getID(){
        try {
            System.out.println("ID : " + json.get("id"));
        } catch (Exception e) {
            System.out.println("No ID present");
        }
    }
    public void getLinkID(){
        try{
            System.out.println("Link ID : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("link_id"));
        }catch(Exception e) {
            System.out.println("No LinkID present");
        }
    }
    public void getTitle(){
        try{
            System.out.println("Title : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("title"));
        }catch(Exception e) {
            System.out.println("No Title present");
        }
    }public void getTxtlyToken(){
        try{
            System.out.println("Token : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("token"));
        }catch(Exception e) {
            System.out.println("No Token present");
        }
    }public void getLongURL(){
        try{
            System.out.println("Long URL : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("long_url"));
        }catch(Exception e) {
            System.out.println("No Long URl present");
        }
    }public void getAdvanced(){
        try{
            System.out.println("Advanced : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("advanced"));
        }catch(Exception e) {
            System.out.println("No Advanced present");
        }
    }public void getLinkType(){
        try{
            System.out.println("Link Type : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("link_type"));
        }catch(Exception e) {
            System.out.println("No Link Type present");
        }
    }public void getCallBack(){
        try{
            System.out.println("Call Back : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("callback"));
        }catch(Exception e) {
            System.out.println("No Call Back present");
        }
    }public void getMetaValue(){
        try{
            System.out.println("Meta Value : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("meta_value"));
        }catch(Exception e) {
            System.out.println("No Meta Value present");
        }
    }public void getViews(){
        try{
            System.out.println("Views : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("views"));
        }catch(Exception e) {
            System.out.println("No Views present");
        }
    }public void getLastViewed(){
        try{
            System.out.println("Last Viewed : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("last_viewed"));
        }catch(Exception e) {
            System.out.println("No Last Viewed present");
        }
    }public void getTxtlyStatus(){
        try{
            System.out.println("Status : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("status"));
        }catch(Exception e) {
            System.out.println("No Status present");
        }
    }public void getCreated(){
        try{
            System.out.println("Created : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("created"));
        }catch(Exception e) {
            System.out.println("No Created present");
        }
    }public void getSerial(){
        try{
            System.out.println("Serial : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getInt("serial"));
        }catch(Exception e) {
            System.out.println("No Serial present");
        }
    }public void getShortURL(){
        try{
            System.out.println("Short URL : "+json.getJSONObject("data").getJSONArray("txtlys").getJSONObject(0).getString("short_url"));
        }catch(Exception e) {
            System.out.println("No Short URL present");
        }
    }
    public void getNow(){
        try{
            System.out.println("Now : "+json.getJSONObject("data").getJSONObject("pagination").getInt("now"));
        }catch(Exception e) {
            System.out.println("No Now present");
        }
    }
    public void getNext(){
        try{
            System.out.println("Next : "+json.getJSONObject("data").getJSONObject("pagination").getBoolean("next"));
        }catch(Exception e) {
            System.out.println("No Next present");
        }
    }
    public void getPage(){
        try{
            System.out.println("Page : "+json.getJSONObject("data").getJSONObject("pagination").getInt("page"));
        }catch(Exception e) {
            System.out.println("No Page present");
        }
    }public void getLimit(){
        try{
            System.out.println("Limit : "+json.getJSONObject("data").getJSONObject("pagination").getInt("limit"));
        }catch(Exception e) {
            System.out.println("No Limit present");
        }
    }public void getLimitStart(){
        try{
            System.out.println("Limit Start : "+json.getJSONObject("data").getJSONObject("pagination").getInt("limitstart"));
        }catch(Exception e) {
            System.out.println("No Limit Start present");
        }
    }public void getExtra(){
        try{
            System.out.println("Extra : "+json.getJSONObject("data").getJSONObject("pagination").get("extra"));
        }catch(Exception e) {
            System.out.println("No Extra present");
        }
    }
}
