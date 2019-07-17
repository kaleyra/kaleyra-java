/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.sms;

import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Validation;

public class ScheduleSMSExample {

    /**
     * Example to schedule an SMS
     * The number has to be 12 digits long including the ISD code
     * Parameters except number and message are optional can be null
     */
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest  =  new SMSMessageRequest(918040275555L, "message",null,null,null,null,null);
        Validation validation  =  new Validation();
        String date  =  validation.validate("dateAndTime", "dateFormat");
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
        if (date.equals(null))
            System.out.println("Invalid date and/or time");
        else if (date.equals("Invalid"))
            System.out.println("Schedule date and time cannot be less than 5 minutes or more than 3 months from now");
        else if(validation.validate(smsMessageRequest.getNumber(),smsMessageRequest.getMessage()) == 1)
            smsMessageResponse = smsMessageRequest.scheduleSMS(date);

        System.out.println(smsMessageResponse.toJson());
    }
}