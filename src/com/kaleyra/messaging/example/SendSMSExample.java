/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;
import com.kaleyra.messaging.api.Validation;

public class SendSMSExample {
    public static void main(String[] args) {
        new Konstants();
        //parameters except number and message can be null
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest(1234567890L,"message",null,null,null,null,null);
        Validation validation=new Validation();
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
       if(validation.validate()==1)
         smsMessageResponse=smsMessageRequest.sendSMS();

       smsMessageResponse.toJson();
    }
}
