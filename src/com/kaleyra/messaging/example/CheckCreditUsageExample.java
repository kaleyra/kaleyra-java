package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;
import com.kaleyra.messaging.api.Validation;

public class CheckCreditUsageExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        Validation validation=new Validation();
        String fromDate = validation.checkDate("2019-06-12", "yyyy-MM-dd");
        String toDate = validation.checkDate("2019-07-09", "yyyy-MM-dd");
        SMSMessageResponse smsMessageResponse=smsMessageRequest.checkCreditUsage(fromDate,toDate);
        smsMessageResponse.toJson();
    }
}
