/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.sms;

import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;

public class DeleteScheduleSMSExample {

    /**
     * Example to delete scheduled SMS
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("groupID");
        SMSMessageResponse smsMessageResponse = smsMessageRequest.deleteSchedule();
        System.out.println(smsMessageResponse.toJSON());
    }
}
