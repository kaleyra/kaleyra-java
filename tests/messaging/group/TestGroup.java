/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package tests.messaging.group;
import api.messaging.group.GroupRequest;
import api.messaging.group.GroupResponse;
import org.junit.jupiter.api.Test;
import utilities.Konstants;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.messaging.group.configTestGroup.*;

class TestGroup {

    /**
     * Method to test creating of group
     */
    @Test
    void testCreateGroup(){
        new Konstants();
        GroupRequest groupRequest = new GroupRequest(groupName1,null);
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
        GroupRequest groupRequest = new GroupRequest(groupName2,null);
        GroupResponse groupResponse = groupRequest.create();
        System.out.println(groupResponse.toJSON());
        groupRequest = new GroupRequest(number1,groupName2,null,null,null);
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
        GroupRequest groupRequest = new GroupRequest(groupName3,null);
        groupRequest.create();
        groupRequest = new GroupRequest(number2,groupName3,null,null,null);
        groupRequest.add();
        groupRequest = new GroupRequest(groupName3,message,null);
        GroupResponse groupResponse = groupRequest.send();
        String message = groupResponse.getMessage();
        String status = groupResponse.getStatus();
        assertEquals("Submitted successfully",message);
        assertEquals("OK",status);
    }
}
