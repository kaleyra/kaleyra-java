/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.sms;

import api.messaging.sms.SMSMessageRequest;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;
import utilities.Validation;

public class CheckCreditUsageExample {

    /**
     * Example to check credit usage from specific date to specific date
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        Validation validation = new Validation();
        String fromDate = validation.checkDate("2019-06-12", "yyyy-MM-dd");
        String toDate = validation.checkDate("2019-07-09", "yyyy-MM-dd");
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkCreditUsage(fromDate,toDate);
        System.out.println(smsMessageResponse.toJSON());
    }
}
