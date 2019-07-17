/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.txtly;

import com.kaleyra.messaging.api.txtly.TxtlyRequest;
import com.kaleyra.messaging.api.txtly.TxtlyResponse;
import com.kaleyra.messaging.api.utilities.Konstants;

public class PullIndividualTxtlyLogsExample {

    /**
     * Example to pull individual Txtly Logs
     */
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest =  new TxtlyRequest(0);
        TxtlyResponse txtlyResponse = txtlyRequest.pullIndividualTxtlyLogs();

        System.out.println(txtlyResponse.toJson());
    }
}