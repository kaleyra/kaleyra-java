/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 */

package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSMessageRequest;
import com.kaleyra.messaging.api.SMSMessageResponse;

public class CheckCreditExample {
    public static void main(String[] args) {
        new Konstants();
        SMSMessageRequest smsMessageRequest = new SMSMessageRequest();
        SMSMessageResponse smsMessageResponse=smsMessageRequest.checkCredits();
        smsMessageResponse.toJson();
    }
}
