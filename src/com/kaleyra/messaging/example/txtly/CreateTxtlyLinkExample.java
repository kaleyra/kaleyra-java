/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.txtly;

import com.kaleyra.messaging.api.txtly.TxtlyRequest;
import com.kaleyra.messaging.api.txtly.TxtlyResponse;
import com.kaleyra.messaging.api.utilities.Konstants;

public class CreateTxtlyLinkExample {

    /**
     * Example to create Txtly Link
     */
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("",null,null,null,null,null,null);
        TxtlyResponse txtlyResponse = txtlyRequest.createTxtlyLink();

        System.out.println(txtlyResponse.toJSON());
    }
}
