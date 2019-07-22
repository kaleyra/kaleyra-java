/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.txtly;

import com.kaleyra.messaging.api.txtly.TxtlyReport;
import com.kaleyra.messaging.api.txtly.TxtlyRequest;
import com.kaleyra.messaging.api.utilities.Konstants;

public class ExtractTxtlyReportsExample {

    /**
     * Example to extract Txtly Reports
     */
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("format","page");
        TxtlyReport txtlyReport = txtlyRequest.extractTxtlyReports();
        System.out.println(txtlyReport.toJSON());
        TxtlyReport.Txtlys[] txtlys = txtlyReport.getTxtlyResponses();
        System.out.println(txtlys[0].getCreated());
        TxtlyReport.Pagination pagination = txtlyReport.getPagination();
        System.out.println(pagination.getLimit());
    }
}
