package com.kaleyra.messaging.api;

import static com.kaleyra.messaging.api.Konstants.*;

public class SMSMessageRequest extends MessageRequest {
    public static String message,url;
    public static long number;
    private static String groupID,dlrURL,custom,unicode,flash,port,format,token,title,advanced,track,attach,page;
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
    public SMSMessageRequest(String url,String format,String token,String title,String advanced,String track,String attach){
        this.url=url;
        this.format=format;
        this.token=token;
        this.title=title;
        this.advanced=advanced;
        this.track=track;
        this.attach=attach;
    }
    public SMSMessageRequest(String format,String page){
        this.format=format;
        this.page=page;
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
        new MessageResponse(urlParameters);
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
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse modifySchedule(String date) {
        String urlParameters = "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&time=" + date + "&task=modify";
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse deleteSchedule (){
        String urlParameters = "api_key=" + apiKey + "&method=sms.schedule&groupid=" + groupID + "&task=delete";
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse checkSMSStatus(){
        String urlParameters = "api_key=" + apiKey + "&method=sms.status&id=" + groupID + "&credits=1";
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse checkCredits(){
        String urlParameters = "api_key=" + apiKey +"&method=account.credits";
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse checkCreditUsage(String fromDate,String toDate){
        String urlParameters = "api_key=" + apiKey +"&method=sms.usagecredit&from=" + fromDate + "&to=" + toDate + "&format=json";
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse createTxtlyLink(){
        String urlParameters ="api_key="+apiKey+"&method=txtly.create&url="+url;
        if(format!=null)
            urlParameters+="&format="+format;
        if(token!=null)
            urlParameters+="&token="+token;
        if(title!=null)
            urlParameters+="&title="+title;
        if(advanced!=null)
            urlParameters+="&advanced="+advanced;
        if(track!=null)
            urlParameters+="&track="+track;
        if(attach!=null)
            urlParameters+="&attach="+attach;
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse extractTxtlyReports(){
        String urlParameters="api_key="+apiKey+"&method=txtly&app=1";
        if(format!=null)
            urlParameters+="&format="+format;
        if(page!=null)
            urlParameters+="&page="+page;
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse pullIndividualTxtlyLogs(){
        String urlParameters="api_key="+apiKey+"&method=txtly.logs&id="+groupID+"&app=1";
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
    @Override
    public SMSMessageResponse deleteTxtlyLink(){
        String urlParameters="api_key="+apiKey+"&method=txtly&task=delete&id="+groupID+"&app=1";
        new MessageResponse(urlParameters);
        return smsMessageResponse;
    }
}



