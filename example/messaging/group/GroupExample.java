/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package example.messaging.group;


import api.messaging.group.GroupRequest;
import api.messaging.group.GroupResponse;
import api.messaging.sms.SMSMessageResponse;
import utilities.Konstants;
import utilities.Validation;

public class GroupExample {

    /**
     * Example to create group,add contact to group and send SMS to group
     * The number has to be 12 digits long including the ISD code
     */
    public static void main(String[] args) {
        new Konstants();
        GroupRequest groupRequest = new GroupRequest("groupName",null);
        GroupResponse groupResponse = groupRequest.create();
        System.out.println(groupResponse.toJSON());
        groupRequest = new GroupRequest("91XXXXXXXXXX","groupName","fullName","emailID",null);
        groupResponse = groupRequest.add();
        System.out.println(groupResponse.toJSON());
        groupRequest = new GroupRequest("groupName","message",null);
        groupResponse = groupRequest.send();
        System.out.println(groupResponse.toJSON());
        SMSMessageResponse[] smsMessageResponses = groupResponse.getSMSMessageResponses();
        System.out.println(smsMessageResponses[0].toJSON());
        System.out.println("Number 1 = " + smsMessageResponses[0].getMobile());
    }
}
