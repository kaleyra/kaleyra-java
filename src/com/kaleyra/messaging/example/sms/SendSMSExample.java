/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.sms;

import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Validation;

public class SendSMSExample {

    /**
     * Example to send SMS immediately
     */
    public static void main(String[] args) {
        new Konstants();
        //parameters except number and message can be null
        SMSMessageRequest smsMessageRequest  =  new SMSMessageRequest(919742052352L,"message",null,null,null,null,null);
        Validation validation = new Validation();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
       if(validation.validate(smsMessageRequest.getNumber(),smsMessageRequest.getMessage()) == 1)
         smsMessageResponse = smsMessageRequest.sendSMS();

        System.out.println(smsMessageResponse.toJson());
    }
}
