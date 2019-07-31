/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.sms;

import api.messaging.sms.SMSMessageRequest;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;

public class DeleteScheduleSMSExample {

    /**
     * Example to delete scheduled SMS
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("");
        SMSMessageResponse smsMessageResponse = smsMessageRequest.deleteSchedule();
        System.out.println(smsMessageResponse.toJSON());
    }
}
