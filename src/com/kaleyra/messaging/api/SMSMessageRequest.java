package com.kaleyra.messaging.api;

import static com.kaleyra.messaging.api.Konstants.*;

public class SMSMessageRequest extends MessageRequest {
    public static String message;
    public static long number;
    private static String groupID,dlrURL,custom,unicode,flash,port;
    public SMSMessageRequest(){

    }
    public SMSMessageRequest(String groupID){ //for deleting and modifying scheduled SMS
        this.groupID=groupID;
    }
    public SMSMessageRequest(long number,String message,String dlrURL,String custom,String unicode,String flash,String port) { //for sending SMS and scheduling SMS
        this.message=message;
        this.number=number;
        this.dlrURL=dlrURL;
        this.custom=custom;
        this.unicode=unicode;
        this.flash=flash;
        this.port=port;
    }
    @Override
    public SMSMessageResponse sendSMS() {
        String urlParameters = "method=sms&message=" + message + "&sender=" + senderID + "&to=" + number + "&api_key=" + apiKey;
        if(dlrURL!=null)
            urlParameters+="&dlrURL="+dlrURL;
        if(custom!=null)
            urlParameters+="&custom="+custom;
        if(unicode!=null)
            urlParameters+="&unicode="+unicode;
        if(flash!=null)
            urlParameters+="&flash="+flash;
        if(port!=null)
            urlParameters+="&port="+port;
        MessageResponse messageResponse=new MessageResponse(urlParameters);
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        return smsMessageResponse;
    }

    @Override
    public SMSMessageResponse scheduleSMS(String date) {
        String urlParameters = "api_key=" + apiKey + "&method=sms&message=" + message + "&to=" + number + "&sender=" + senderID + "&time=" + date;
        if(dlrURL!=null)
            urlParameters+="&dlrURL="+dlrURL;
        if(custom!=null)
            urlParameters+="&custom="+custom;
        if(unicode!=null)
            urlParameters+="&unicode="+unicode;
        if(flash!=null)
            urlParameters+="&flash="+flash;
        if(port!=null)
            urlParameters+="&port="+port;
        MessageResponse messageResponse=new MessageResponse(urlParameters);
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse modifySchedule(String date) {
        String urlParameters = "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&time=" + date + "&task=modify";
        MessageResponse messageResponse=new MessageResponse(urlParameters);
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse deleteSchedule (){
        String urlParameters = "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&task=delete";
        MessageResponse messageResponse=new MessageResponse(urlParameters);
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse checkSMSStatus(){
        String urlParameters = "api_key=" + apiKey + "&method=sms.status&id=" + groupID + "&credits=1";
        MessageResponse messageResponse=new MessageResponse(urlParameters);
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse checkCredits(){
        String urlParameters = "api_key=" + apiKey +"&method=account.credits";
        MessageResponse messageResponse=new MessageResponse(urlParameters);
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse checkCreditUsage(String fromDate,String toDate){
        String urlParameters = "api_key=" + apiKey +"&method=sms.usagecredit&from=" + fromDate + "&to=" + toDate + "&format=json";
        MessageResponse messageResponse=new MessageResponse(urlParameters);
        SMSMessageResponse smsMessageResponse=new SMSMessageResponse();
        return smsMessageResponse;
    }
}



