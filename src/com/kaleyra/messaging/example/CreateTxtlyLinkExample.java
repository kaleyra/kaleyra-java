package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;

public class CreateTxtlyLinkExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("","format","token","title","advanced","track","attach");
        SMSMessageResponse smsMessageResponse=smsMessageRequest.createTxtlyLink();

        smsMessageResponse.toJson();
    }
}
