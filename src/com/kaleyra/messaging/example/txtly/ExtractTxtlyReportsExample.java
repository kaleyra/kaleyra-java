/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example.txtly;

import com.kaleyra.messaging.api.txtly.TxtlyRequest;
import com.kaleyra.messaging.api.txtly.TxtlyResponse;
import com.kaleyra.messaging.api.utilities.Konstants;

//Example to extract txtly reports
public class ExtractTxtlyReportsExample {
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("","");
        TxtlyResponse txtlyResponse = txtlyRequest.extractTxtlyReports();

        System.out.println(txtlyResponse.toJson());
    }
}
