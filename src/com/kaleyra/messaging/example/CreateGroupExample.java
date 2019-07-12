/*
 * -*- coding: utf-8 -*-
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example;

import com.kaleyra.messaging.api.*;

public class CreateGroupExample {
    public static void main(String[] args) {
        new Konstants();
        SMSGroupRequest smsGroupRequest = new SMSGroupRequest("GroupName",null);
        SMSGroupResponse smsGroupResponse =smsGroupRequest.createGroup();

        smsGroupResponse.toJson();
    }
}
