package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.*;

public class DeleteTxtlyLinkExample {
    public static void main(String[] args) {
        new Konstants();
        TxtlyRequest txtlyRequest= new TxtlyRequest("");
        TxtlyResponse txtlyResponse=txtlyRequest.deleteTxtlyLink();

        txtlyResponse.toJson();
    }
}
