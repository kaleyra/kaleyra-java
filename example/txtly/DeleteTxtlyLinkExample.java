/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.txtly;

import api.txtly.TxtlyRequest;
import api.txtly.TxtlyResponse;
import utilities.Konstants;

public class DeleteTxtlyLinkExample {

    /**
     * Example to delete Txtly Link
     */
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest = new TxtlyRequest(0);
        TxtlyResponse txtlyResponse = txtlyRequest.deleteTxtlyLink();

        System.out.println(txtlyResponse.toJSON());
    }
}
