/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

import com.kaleyra.messaging.api.sms.SMSMessageRequest;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Konstants;
import com.kaleyra.messaging.api.utilities.Validation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSMS {
    private long number = 919742052352L;
    private String message = "Hello_there";
    private String scheduleDate = "16-07-2019 07:00 PM",scheduleFormat = "dd-MM-yyyy hh:mm a";
    private String modifyDate = "16-07-2019 10:00 PM",modifyFormat = "dd-MM-yyyy hh:mm a";
    private String fromDate="12-06-2019",toDate="11-07-2019",creditFormat="dd-MM-yyyy";

    /**
     * Method to test sending SMS
     */
    @Test
    void testSendSMS(){
        new Konstants();
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.send();
        String message=smsMessageResponse.getMessage();
        assertEquals("Campaign of 1 numbers Submitted successfully.",message);
        String status=smsMessageResponse.getStatus();
        assertEquals("AWAITED-DLR",status);
    }

    /**
     * Method to test scheduling of SMS
     */
    @Test
    void testScheduleSMS(){
        new Konstants();
        Validation validation=new Validation();
        String finalDate=validation.validate(scheduleDate,scheduleFormat);
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.scheduleSMS(finalDate);
        String message=smsMessageResponse.getMessage();
        assertEquals("Campaign of 1 numbers Scheduled successfully.",message);
        String status=smsMessageResponse.getStatus();
        assertEquals("AWAITED-DLR",status);
    }

    /**
     * Method to test modification of scheduled SMS
     */
    @Test
    void testModifyScheduleSMS(){
        new Konstants();
        Validation validation=new Validation();
        String finalDate=validation.validate(scheduleDate,scheduleFormat);
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.scheduleSMS(finalDate);
        smsMessageRequest = new SMSMessageRequest(smsMessageResponse.getID());
        finalDate=validation.validate(modifyDate,modifyFormat);
        smsMessageResponse = smsMessageRequest.modifySchedule(finalDate);
        String message=smsMessageResponse.getMessage();
        assertEquals("Campaign updated successfully",message);
        String status=smsMessageResponse.getStatus();
        assertEquals("OK",status);
    }

    /**
     * Method to test deletion of scheduled SMS
     */
    @Test
    void testDeleteScheduleSMS(){
        new Konstants();
        Validation validation=new Validation();
        String finalDate=validation.validate(scheduleDate,scheduleFormat);
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.scheduleSMS(finalDate);
        smsMessageRequest = new SMSMessageRequest(smsMessageResponse.getID());
        smsMessageResponse = smsMessageRequest.deleteSchedule();
        String message=smsMessageResponse.getMessage();
        assertEquals("Campaign canceled successfully and credits are refunded.",message);
        String status=smsMessageResponse.getStatus();
        assertEquals("OK",status);
    }

    /**
     * Method to test checking credits available
     */
    @Test
    void testCheckCredit(){
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkCredits();
        String message=smsMessageResponse.getMessage();
        String status=smsMessageResponse.getStatus();
        assertEquals("",message);
        assertEquals("OK",status);
    }

    /**
     * Method to test checking credit usage from specific date to specific date
     */
    @Test
    void testCheckCreditUsage(){
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        Validation validation = new Validation();
        String fromDay=validation.checkDate(fromDate,creditFormat);
        String toDay=validation.checkDate(toDate,creditFormat);
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkCreditUsage(fromDay,toDay);
        String status=smsMessageResponse.getStatus();
        assertEquals("OK",status);
    }

    /**
     * Method to test checking of SMS status
     */
    @Test
    void testCheckSMSStatus(){
        new Konstants();
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.send();
        smsMessageRequest = new SMSMessageRequest(smsMessageResponse.getID());
        smsMessageResponse = smsMessageRequest.checkSMSStatus();
        String message=smsMessageResponse.getMessage();
        String status=smsMessageResponse.getStatus();
        assertEquals("Processed Successfully",message);
        assertEquals("OK",status);
    }
}