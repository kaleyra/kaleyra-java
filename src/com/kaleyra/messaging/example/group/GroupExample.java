/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author : Viram Jain
 */

package com.kaleyra.messaging.example.group;

import com.kaleyra.messaging.api.group.GroupRequest;
import com.kaleyra.messaging.api.group.GroupResponse;
import com.kaleyra.messaging.api.sms.SMSMessageResponse;
import com.kaleyra.messaging.api.utilities.Konstants;

//Example to create group,add contacts to the group and send SMS to the group
public class GroupExample {
    public static void main(String[] args) {
        new Konstants();
        GroupRequest groupRequest = new GroupRequest("Group",null);
        GroupResponse groupResponse = groupRequest.createGroup();
        System.out.println(groupResponse.toJson());
        groupRequest = new GroupRequest(9742052352L,"Group","Viram Jain","viramjain9742@gmail.com",null);
        groupResponse  =  groupRequest.addContact();
        System.out.println(groupResponse.toJson());
        groupRequest = new GroupRequest(8970736699L,"Group","Yashita Jain","ypj247@gmail.com",null);
        groupResponse =  groupRequest.addContact();
        System.out.println(groupResponse.toJson());
        groupRequest = new GroupRequest("Group","Hello",null);
        groupResponse = groupRequest.sendGroupSMS();
        System.out.println(groupResponse.toJson());
        SMSMessageResponse[] smsMessageResponses = groupResponse.getSMSMessageResponses();
        System.out.println(smsMessageResponses[0].toJson());
    }
}
