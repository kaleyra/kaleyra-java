/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example.sms;

import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Validation;

//Example to schedule SMS
public class ScheduleSMSExample {
    public static void main(String[] args) {
        new Konstants();
        //parameters except number and message can be null
        SMSMessageRequest smsMessageRequest  =  new SMSMessageRequest(1234567890L, "message", "dlrURL", "custom", "unicode", "flash", "port");
        Validation validation  =  new Validation();
        String date  =  validation.validate("dateAndTime", "dateFormat");
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
        if (date == null)
            System.out.println("Invalid date and/or time");
        else if (date.equals("Invalid"))
            System.out.println("Schedule date and time cannot be less than 5 minutes or more than 3 months from now");
        else if(validation.validate() == 1)
            smsMessageResponse = smsMessageRequest.scheduleSMS(date);

        System.out.println(smsMessageResponse.toJson());
    }
}
