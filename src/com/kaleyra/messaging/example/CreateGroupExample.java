package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.*;

public class CreateGroupExample {
    public static void main(String[] args) {
        new Konstants();
        SMSGroupRequest smsGroupRequest = new SMSGroupRequest("Group",null);
        SMSGroupResponse smsGroupResponse =smsGroupRequest.createGroup();

        smsGroupResponse.toJson();
    }
}
