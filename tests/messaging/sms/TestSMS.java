/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package tests.messaging.sms;import api.messaging.sms.SMSMessageRequest;

import api.messaging.sms.SMSMessageResponse;
import org.junit.jupiter.api.Test;
import utilities.Konstants;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.messaging.sms.configTestSMS.*;

class TestSMS {

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
        String status=smsMessageResponse.getDlrStatus();
        assertEquals("AWAITED-DLR",status);
    }

    /**
     * Method to test scheduling of SMS
     */
    @Test
    void testScheduleSMS(){
        new Konstants();
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        smsMessageRequest.setSchedule(scheduleDate,scheduleFormat);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.scheduleSMS();
        String message=smsMessageResponse.getMessage();
        assertEquals("Campaign of 1 numbers Scheduled successfully.",message);
        String status=smsMessageResponse.getDlrStatus();
        assertEquals("AWAITED-DLR",status);
    }

    /**
     * Method to test modification of scheduled SMS
     */
    @Test
    void testEditScheduleSMS(){
        new Konstants();
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        smsMessageRequest.setSchedule(scheduleDate,scheduleFormat);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.scheduleSMS();
        smsMessageRequest = new SMSMessageRequest(smsMessageResponse.getID());
        smsMessageRequest.setSchedule(modifyDate,modifyFormat);
        smsMessageResponse = smsMessageRequest.editSchedule();
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
        SMSMessageRequest smsMessageRequest=new SMSMessageRequest(number,message,null,null,null,null,null);
        smsMessageRequest.setSchedule(scheduleDate,scheduleFormat);
        SMSMessageResponse smsMessageResponse=smsMessageRequest.scheduleSMS();
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
        SMSMessageResponse smsMessageResponse = smsMessageRequest.checkCreditUsage(fromDate,toDate,creditFormat);
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