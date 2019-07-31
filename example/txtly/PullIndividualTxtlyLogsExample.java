/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.txtly;

import api.txtly.TxtlyIndividualLogs;
import api.txtly.TxtlyRequest;
import utilities.Konstants;

public class PullIndividualTxtlyLogsExample {

    /**
     * Example to pull individual Txtly Logs
     */
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest =  new TxtlyRequest(0); //Enter your Txtly ID
        TxtlyIndividualLogs txtlyIndividualLogs = txtlyRequest.pullIndividualTxtlyLogs();

        System.out.println(txtlyIndividualLogs.toJSON());
        TxtlyIndividualLogs.Pagination pagination = txtlyIndividualLogs.getPagination();
        System.out.println(pagination.getLimit());
    }
}
