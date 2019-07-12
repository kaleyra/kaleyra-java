/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 */

package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.*;

public class CreateTxtlyLinkExample {
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("","format","token","title","advanced","track","attach");
        TxtlyResponse txtlyResponse =txtlyRequest.createTxtlyLink();

        txtlyResponse.toJson();
    }
}
