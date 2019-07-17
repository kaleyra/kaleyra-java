/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.sms;

import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;

public class CheckCreditExample {

    /**
     * Example to check credits remaining in user's account
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkCredits();
        System.out.println(smsMessageResponse.toJson());
    }
}
