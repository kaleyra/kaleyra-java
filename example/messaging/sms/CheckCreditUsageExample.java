/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.sms;

import api.messaging.sms.SMSMessageRequest;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;

public class CheckCreditUsageExample {

    /**
     * Example to check credit usage from specific date to specific date
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkCreditUsage("10-06-2019","10-07-2019","dd-MM-yyyy");
        System.out.println(smsMessageResponse.toJSON());
    }
}
