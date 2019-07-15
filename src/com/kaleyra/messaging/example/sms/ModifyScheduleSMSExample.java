/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.sms;

import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Validation;

//Example to modify scheduled SMS
public class ModifyScheduleSMSExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("groupID");
        Validation validate = new Validation();
        SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
        String date = validate.validate("dateAndTime","dateFormat");
        if(date == null)
            System.out.println("Invalid date and/or time");
        else if(date.equals("Invalid"))
            System.out.println("Schedule date and time cannot be less than 5 minutes or more than 3 months from now");
        else
            smsMessageResponse = smsMessageRequest.modifySchedule(date);

        System.out.println(smsMessageResponse.toJson());
    }
}
