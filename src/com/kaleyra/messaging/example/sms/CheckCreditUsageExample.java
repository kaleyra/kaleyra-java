/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example.sms;

import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Validation;

//Example to check credit usage between 2 dates
public class CheckCreditUsageExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        Validation validation = new Validation();
        String fromDate = validation.checkDate("2019-06-12", "yyyy-MM-dd");
        String toDate = validation.checkDate("2019-07-09", "yyyy-MM-dd");
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkCreditUsage(fromDate,toDate);
        System.out.println(smsMessageResponse.toJson());
    }
}
