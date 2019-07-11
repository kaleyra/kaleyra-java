package com.kaleyra.messaging.api;


public class MessageRequest{
    SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
    public SMSMessageResponse sendSMS(){ return smsMessageResponse; }
    public SMSMessageResponse scheduleSMS(String date){
        return smsMessageResponse;
    }
    public SMSMessageResponse modifySchedule(String date){
        return smsMessageResponse;
    }
    public SMSMessageResponse deleteSchedule(){
        return smsMessageResponse;
    }
    public SMSMessageResponse checkSMSStatus(){return smsMessageResponse;}
    public SMSMessageResponse checkCredits(){ return smsMessageResponse;}
    public SMSMessageResponse checkCreditUsage(String fromDate,String toDate){ return smsMessageResponse;}
    public SMSMessageResponse createTxtlyLink(){return smsMessageResponse;}
    public SMSMessageResponse extractTxtlyReports(){return smsMessageResponse;}
    public SMSMessageResponse pullIndividualTxtlyLogs(){return smsMessageResponse;}
    public SMSMessageResponse deleteTxtlyLink(){return smsMessageResponse;}
}
