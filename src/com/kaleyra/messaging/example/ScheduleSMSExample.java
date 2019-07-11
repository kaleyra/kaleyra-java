package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;
import com.kaleyra.messaging.api.Validation;

public class ScheduleSMSExample {
    public static void main(String[] args) {
        new Konstants();
        //parameters except number and message can be null
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest(1234567890L, "message", "dlrURL", "custom", "unicode", "flash", "port");
        Validation validation = new Validation();
        String date = validation.validate("dateAndTime", "dateFormat");
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        if (date == null)
            System.out.println("Invalid date and/or time");
        else if (date.equals("Invalid"))
            System.out.println("Schedule date and time cannot be less than 5 minutes or more than 3 months from now");
        else if(validation.validate()==1)
            smsMessageResponse=smsMessageRequest.scheduleSMS(date);

        smsMessageResponse.toJson();
    }
}
