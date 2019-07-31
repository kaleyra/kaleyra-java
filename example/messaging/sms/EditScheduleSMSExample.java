/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.sms;

import api.messaging.sms.SMSMessageRequest;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;

public class EditScheduleSMSExample {

    /**
     * Example to modify scheduled SMS (Only date and time can be modified)
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("");
        smsMessageRequest.setSchedule("","");
        SMSMessageResponse smsMessageResponse = smsMessageRequest.editSchedule();

        System.out.println(smsMessageResponse.toJSON());
    }
}
