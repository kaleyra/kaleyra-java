/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.sms;

import api.messaging.sms.SMSMessageRequest;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;

public class CheckSMSStatusExample {

    /**
     * Example to check SMS status
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("");
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkSMSStatus();
        System.out.println(smsMessageResponse.toJSON());
    }
}