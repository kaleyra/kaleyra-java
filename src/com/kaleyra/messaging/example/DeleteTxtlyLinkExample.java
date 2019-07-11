package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;

public class DeleteTxtlyLinkExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("");
        SMSMessageResponse smsMessageResponse=smsMessageRequest.deleteTxtlyLink();

        smsMessageResponse.toJson();
    }
}
