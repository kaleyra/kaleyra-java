/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example.txtly;

import com.kaleyra.messaging.api.txtly.TxtlyRequest;
import com.kaleyra.messaging.api.txtly.TxtlyResponse;
import com.kaleyra.messaging.api.utilities.Konstants;

//Example to create txtly link
public class CreateTxtlyLinkExample {
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("url","format","token","title","advanced","track","attach");
        TxtlyResponse txtlyResponse = txtlyRequest.createTxtlyLink();

        System.out.println(txtlyResponse.toJson());
    }
}
