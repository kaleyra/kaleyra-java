/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.example.group;

import com.kaleyra.messaging.api.group.GroupRequest;
import com.kaleyra.messaging.api.group.GroupResponse;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Konstants;

public class GroupExample {

    /**
     * Example to createGroup,addContact to group and send SMS to group
     */
    public static void main(String[] args) {
        new Konstants();
        GroupRequest groupRequest = new GroupRequest("GroupName",null);
        GroupResponse groupResponse = groupRequest.createGroup();
        System.out.println(groupResponse.toJson());
        groupRequest = new GroupRequest(9742052352L,"Group","Viram Jain","viramjain9742@gmail.com",null);
        groupResponse  =  groupRequest.addContact();
        System.out.println(groupResponse.toJson());
        groupRequest = new GroupRequest("Group","Hello",null);
        groupResponse = groupRequest.sendGroupSMS();
        System.out.println(groupResponse.toJson());
        SMSMessageResponse[] smsMessageResponses = groupResponse.getSMSMessageResponses();
        System.out.println(smsMessageResponses[0].toJson());
        System.out.println("Number 1 = " + smsMessageResponses[0].getMobile());
    }
}
