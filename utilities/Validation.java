/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    /**
     * Method to validate number
     * @return 0 if invalid or 1 if valid
     */
    public static int validateNumber(String number){
        if(number.length() != 12||number.contains("[a-zA-Z]+")){
            System.out.println("Invalid Number,Please enter a valid 12 digit number with ISD code");
            return 0;
        }
        else
            return 1;
    }

    /**
     * Method to validate number and message
     * @return 0 if invalid and 1 if valid
     */
    public static int validateMessage(String message){
        if(message.equals("")){
            System.out.println("Message cannot be null");
            return 0;
        }
        else
            return 1;
    }
    /**
     * Method to validate number and message
     * @return 0 if invalid and 1 if valid
     */
    public static int validateNumberAndMessage(String number,String message){
        if(message.equals("")&&number.length() != 12){
            System.out.println("Message cannot be null");
            System.out.println("Invalid Number,Please enter a valid 12 digit number with ISD code");
            return 0;
        }
        else if(message.equals("")){
            System.out.println("Message cannot be null");
            return 0;
        }
        else if(number.length() != 12||number.contains("[a-zA-Z]+")){
            System.out.println("Invalid Number,Please enter a valid 12 digit number with ISD code");
            return 0;
        }
        else
            return 1;
    }

    /**
     * Method to validate dateAndTime and format specified by the user
     * @return null if dateAndTime is invalid else finalDate which is in the API required format
     */
    public static String validate(String dateAndTime,String dateFormat){
        String pattern = "yyyy-MM-dd hh:mm a",finalDate = null;
        Date date;
        if(dateAndTime == null) {
            return null;
        }
        try {
            if (new SimpleDateFormat(dateFormat).parse(dateAndTime).before(new Date())){
                return "Past";
            }
        } catch (ParseException e) {

        }
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                date = sdf.parse(dateAndTime);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                finalDate = simpleDateFormat.format(date);
                try {
                    Date currentDate = new Date();
                    long diff = date.getTime() - currentDate.getTime();
                    long diffMinutes = diff / (60*1000);
                    if (diffMinutes < 5 || diffMinutes > 131400) {
                        return("Invalid");
                    }
                }catch(Exception e){

                }
            } catch (ParseException e) {

            }
        return finalDate;
    }

    /**
     * Method to validate dateGiven and format specified by the user
     * @return null if dateGiven is invalid else finalDate which is in the API required format
     */
    public static String checkDate(String dateGiven,String dateFormat){
        String pattern = "yyyy-MM-dd",finalDate = null;
        Date date;
        if(dateGiven == null) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            date = sdf.parse(dateGiven);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            finalDate = simpleDateFormat.format(date);
        } catch (ParseException e) {

        }
        return finalDate;
    }
}
