/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.sms;

/**
 * Super class of SMSMessageRequest
 */
public class MessageRequest{
    SMSMessageResponse smsMessageResponse = new SMSMessageResponse();
    public SMSMessageResponse sendSMS(){
        return smsMessageResponse;
    }
    public SMSMessageResponse scheduleSMS(String date){
        return smsMessageResponse;
    }
    public SMSMessageResponse modifySchedule(String date){
        return smsMessageResponse;
    }
    public SMSMessageResponse deleteSchedule(){
        return smsMessageResponse;
    }
    public SMSMessageResponse checkSMSStatus(){
        return  smsMessageResponse;
    }
    public SMSMessageResponse checkCredits(){
        return smsMessageResponse;
    }
    public SMSMessageResponse checkCreditUsage(String fromDate,String toDate){
        return smsMessageResponse;
    }
}
