/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.txtly;

import api.txtly.TxtlyRequest;
import api.txtly.TxtlyResponse;
import utilities.Konstants;

public class CreateTxtlyLinkExample {

    /**
     * Example to create Txtly Link
     */
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest("https://apidocs-sms.kaleyra.com",null,null,null,null,null,null);
        TxtlyResponse txtlyResponse = txtlyRequest.createTxtlyLink();

        System.out.println(txtlyResponse.toJSON());
    }
}
