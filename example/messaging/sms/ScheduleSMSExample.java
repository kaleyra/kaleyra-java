/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.sms;

import api.messaging.sms.SMSMessageRequest;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;

public class ScheduleSMSExample {

    /**
     * Example to schedule an SMS
     * The number has to be 12 digits long including the ISD code
     * Parameters except number and message are optional which can be null
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest  =  new SMSMessageRequest("91XXXXXXXXXX", "message",null,null,null,null,null);
        smsMessageRequest.setSchedule("dateAndTime", "dateFormat");
        SMSMessageResponse smsMessageResponse = smsMessageRequest.scheduleSMS();

        System.out.println(smsMessageResponse.toJSON());
    }
}
