/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 */

package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;
import com.kaleyra.messaging.api.Validation;

public class ModifyScheduleSMSExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest("groupID");
        Validation validate=new Validation();
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        String date=validate.validate("dateAndTime","dateFormat");
        if(date==null)
            System.out.println("Invalid date and/or time");
        else if(date.equals("Invalid"))
            System.out.println("Schedule date and time cannot be less than 5 minutes or more than 3 months from now");
        else
            smsMessageResponse=smsMessageRequest.modifySchedule(date);

        smsMessageResponse.toJson();
    }
}
