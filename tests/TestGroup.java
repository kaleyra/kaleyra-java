/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

import com.kaleyra.messaging.api.group.GroupRequest;
import com.kaleyra.messaging.api.group.GroupResponse;
import com.kaleyra.messaging.api.utilities.Konstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestGroup {

    /**
     * Method to test creating of group
     */
    @Test
    void testCreateGroup(){
        new Konstants();
        GroupRequest groupRequest = new GroupRequest("Group",null);
        GroupResponse groupResponse = groupRequest.createGroup();
        String message=groupResponse.getMessage();
        String status=groupResponse.getStatusMessage();
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
        GroupResponse groupResponse = groupRequest.createGroup();
        System.out.println(groupResponse.toJson());
        groupRequest = new GroupRequest(8040275555L,"GroupName","Viram Jain","viramjain9742@gmail.com",null);
        groupResponse = groupRequest.addContact();
        String message = groupResponse.getMessage();
        String status = groupResponse.getStatusMessage();
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
        groupRequest.createGroup();
        groupRequest = new GroupRequest(9742052352L,"GroupName","Viram Jain","viramjain9742@gmail.com",null);
        groupRequest.addContact();
        groupRequest = new GroupRequest("GroupName","Hello",null);
        GroupResponse groupResponse = groupRequest.sendGroupSMS();
        String message = groupResponse.getMessage();
        String status = groupResponse.getStatusMessage();
        assertEquals("Submitted successfully",message);
        assertEquals("OK",status);
    }
}
