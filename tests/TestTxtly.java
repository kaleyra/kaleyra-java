/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */


import api.txtly.TxtlyIndividualLogs;
import api.txtly.TxtlyReport;
import api.txtly.TxtlyRequest;
import api.txtly.TxtlyResponse;
import org.junit.Test;
import utilities.Konstants;
import static junit.framework.TestCase.assertEquals;

class TestTxtly {

    /**
     * Method to test creation of Txtly link
     */
    @Test
    void testCreateTxtly() {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("http://msg.mn/bKX6yf", "json", null,null,null,null,null);
        TxtlyResponse txtlyResponse = txtlyRequest.createTxtlyLink();
        String message=txtlyResponse.getMessage();
        String status=txtlyResponse.getStatusMessage();
        assertEquals("Details saved Successfully",message);
        assertEquals("OK",status);
    }

    /**
     * Method to test extracting Txtly reports
     */
    @Test
    void testExtractTxtlyReports(){
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("json","1");
        TxtlyReport txtlyReport = txtlyRequest.extractTxtlyReports();
        String message=txtlyReport.getMessage();
        String status=txtlyReport.getStatusMessage();
        assertEquals("OK",message);
        assertEquals("OK",status);
    }

    /**
     * Method to test pulling of individual Txtly logs
     */
    @Test
    void testPullIndividualTxtlyLogs(){
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("http://msg.mn/bKX6yf", "json", null,null,null,null,null);
        TxtlyResponse txtlyResponse = txtlyRequest.createTxtlyLink();
        txtlyRequest =  new TxtlyRequest(txtlyResponse.getID());
        TxtlyIndividualLogs txtlyIndividualLogs = txtlyRequest.pullIndividualTxtlyLogs();
        String message = txtlyIndividualLogs.getMessage();
        String status = txtlyIndividualLogs.getStatusMessage();
        assertEquals("OK",message);
        assertEquals("OK",status);
    }

    /**
     * Method to test deletion of Txtly link
     */
    @Test
    void testDeleteTxtlyLink(){
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("http://msg.mn/bKX6yf", "json", null,null,null,null,null);
        TxtlyResponse txtlyResponse = txtlyRequest.createTxtlyLink();
        txtlyRequest =  new TxtlyRequest(txtlyResponse.getID());
        txtlyResponse = txtlyRequest.deleteTxtlyLink();
        String message=txtlyResponse.getMessage();
        String status=txtlyResponse.getStatusMessage();
        assertEquals("Deleted successfully..",message);
        assertEquals("OK",status);
    }
}
