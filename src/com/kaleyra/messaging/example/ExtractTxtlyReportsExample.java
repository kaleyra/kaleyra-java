package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;

public class ExtractTxtlyReportsExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("","");
        SMSMessageResponse smsMessageResponse=smsMessageRequest.extractTxtlyReports();

        smsMessageResponse.toJson();
    }
}
