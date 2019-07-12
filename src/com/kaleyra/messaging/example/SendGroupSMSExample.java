/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.Konstants;
import com.kaleyra.messaging.api.SMSGroupRequest;
import com.kaleyra.messaging.api.SMSGroupResponse;

public class SendGroupSMSExample {
    public static void main(String[] args) {
        new Konstants();
        SMSGroupRequest smsGroupRequest = new SMSGroupRequest("Group","Hello",null);
        SMSGroupResponse smsGroupResponse = smsGroupRequest.sendGroupSMS();

        smsGroupResponse.toJson();
    }
}
