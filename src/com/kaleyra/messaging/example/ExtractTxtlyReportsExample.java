/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 */

package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.*;

public class ExtractTxtlyReportsExample {
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("","");
        TxtlyResponse txtlyResponse=txtlyRequest.extractTxtlyReports();

        txtlyResponse.toJson();
    }
}
