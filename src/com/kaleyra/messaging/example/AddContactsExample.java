package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSGroupRequest;
import com.kaleyra.messaging.api.SMSGroupResponse;

public class AddContactsExample {
    public static void main(String[] args) {
        new Konstants();
        SMSGroupRequest smsGroupRequest = new SMSGroupRequest(9742052352L,"Group","Viram Jain","viramjain9742@gmail.com",null);
        SMSGroupResponse smsGroupResponse =smsGroupRequest.addContacts();

        smsGroupResponse.toJson();
    }
}
