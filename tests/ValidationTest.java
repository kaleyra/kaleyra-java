/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package tests;


import org.junit.jupiter.api.Test;
import utilities.Validation;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Class to test validation for date and time
 */
class ValidationTest {
    private Validation validation  =  new Validation();
    private String dateAndTime,format,date;

    @Test
    void validate0() {
        dateAndTime = "17-07-2019 04:45 PM";
        format = "dd-MM-yyyy hh:mm a";
        date = validation.validate(dateAndTime, format);
        assertEquals("Past", date);
    }
    @Test
    void validate1(){
        dateAndTime = "12/05/2019 04:45 PM";
        format = "dd/MM/yyyy hh:mm a";
        date = validation.validate(dateAndTime, format);
        assertEquals("Past", date);
    }
    @Test
    void validate2(){
        dateAndTime = "12 SEP 2019 14:45";
        format = "dd MMM yyyy HH:mm";
        date = validation.validate(dateAndTime,format);
        assertEquals("2019-09-12 02:45 PM",date);
    }
    @Test
    void validate3(){
        dateAndTime = "12/11/19 02:45 PM";
        format = "dd/MM/yy hh:mm a";
        date = validation.validate(dateAndTime,format);
        assertEquals("Invalid",date);
    }
    @Test
    void validate4(){
        dateAndTime = "12 June,2019 14:13";
        format = "dd MMM,yyyy HH:mm";
        date = validation.validate(dateAndTime,format);
        assertEquals("Past",date);
    }
    @Test
    void validate5(){
        dateAndTime = "12-AUG-2019 14:13";
        format = "dd-MMM-yyyy HH:mm";
        date = validation.validate(dateAndTime,format);
        assertEquals("2019-08-12 02:13 PM",date);
    }
    @Test
    void validate6(){
        dateAndTime = "SEP 12 2019 02:45 AM";
        format = "MMM dd yyyy hh:mm a";
        date = validation.validate(dateAndTime,format);
        assertEquals("2019-09-12 02:45 AM",date);
    }
    @Test
    void validate7(){
        dateAndTime = "30 FEB 2020 05:30 PM";
        format = "dd MMM yyyy hh:mm a";
        date = validation.validate(dateAndTime,format);
        assertEquals("Invalid",date);
    }
    @Test
    void validate8(){
        dateAndTime = "2019-08-07 05:30 PM";
        format = "yyyy-MM-dd hh:mm a";
        date = validation.validate(dateAndTime,format);
        assertEquals("2019-08-07 05:30 PM",date);
    }
}