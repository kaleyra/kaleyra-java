package com.kaleyra.messaging.api;

public class SMSMessageResponse extends MessageResponse{
    public void getID() {
        try{
            System.out.println("ID : "+json.getJSONArray("data").getJSONObject(0).getString("id"));
        }catch(Exception e) {
            System.out.println("No CustomID present");
        }
    }
    public void getCustomid() {
        try{
            System.out.println("Customid : "+json.getJSONArray("data").getJSONObject(0).getString("customid"));
        }catch(Exception e) {
            System.out.println("No CustomID present");
        }
    }
    public void getCustomid1() {
        try{
            System.out.println("CustomID1 : "+json.getJSONArray("data").getJSONObject(0).getString("customid1"));
        }catch(Exception e) {
            System.out.println("No CustomID1 present");
        }
    }
    public void getCustomid2() {
        try{
            System.out.println("CustomID2 : "+json.getJSONArray("data").getJSONObject(0).getString("customid2"));
        }catch(Exception e) {
            System.out.println("No CustomID2 present");
        }
    }
    public void getMobile() {
        try{
            System.out.println("Mobile : "+json.getJSONArray("data").getJSONObject(0).getString("mobile"));
        }catch(Exception e) {
            System.out.println("No Mobile present");
        }
    }
    public void getStatus() {
        try{
            System.out.println("Status : "+json.getJSONArray("data").getJSONObject(0).getString("status"));
        }catch(Exception e) {
            System.out.println("No Status present");
        }
    }
}
