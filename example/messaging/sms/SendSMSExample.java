/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.sms;

import api.messaging.sms.SMSMessageRequest;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;

public class SendSMSExample {

    /**
     * Example to send SMS immediately
     * The number has to be 12 digits long including the ISD code succeeded by 'L'
     * Parameters except number and message are optional and can be null
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest  =  new SMSMessageRequest(910000000000L,"message",null,null,null,null,null);
        SMSMessageResponse smsMessageResponse = smsMessageRequest.send();

        System.out.println(smsMessageResponse.toJSON());
    }
}
