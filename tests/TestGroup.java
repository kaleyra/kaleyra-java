/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */


import api.messaging.group.GroupRequest;
import api.messaging.group.GroupResponse;
import org.junit.Test;
import utilities.Konstants;

import static junit.framework.TestCase.assertEquals;

class TestGroup {

    /**
     * Method to test creating of group
     */
    @Test
    void testCreateGroup(){
        new Konstants();
        GroupRequest groupRequest = new GroupRequest("Group",null);
        GroupResponse groupResponse = groupRequest.create();
        String message=groupResponse.getMessage();
        String status=groupResponse.getStatus();
        assertEquals("Group added Successfully",message);
        assertEquals("OK",status);
    }

    /**
     * Method to test adding contacts to the group
     */
    @Test
    void testAddContacts(){
        new Konstants();
        GroupRequest groupRequest = new GroupRequest("GroupName",null);
        GroupResponse groupResponse = groupRequest.create();
        System.out.println(groupResponse.toJSON());
        groupRequest = new GroupRequest(918040275555L,"GroupName","Viram Jain","viramjain9742@gmail.com",null);
        groupResponse = groupRequest.add();
        String message = groupResponse.getMessage();
        String status = groupResponse.getStatus();
        assertEquals("Number has been added Successfully",message);
        assertEquals("OK",status);
    }

    /**
     * Method to test sending SMS to the group
     */
    @Test
    void testSendGroupSMS(){
        new Konstants();
        GroupRequest groupRequest = new GroupRequest("GroupName",null);
        groupRequest.create();
        groupRequest = new GroupRequest(919742052352L,"GroupName","Viram Jain","viramjain9742@gmail.com",null);
        groupRequest.add();
        groupRequest = new GroupRequest("GroupName","Hello",null);
        GroupResponse groupResponse = groupRequest.send();
        String message = groupResponse.getMessage();
        String status = groupResponse.getStatus();
        assertEquals("Submitted successfully",message);
        assertEquals("OK",status);
    }
}
