package com.kaleyra.messaging.api;

import static com.kaleyra.messaging.api.SMSMessageRequest.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    public int validate(){ //Validation message and number
        String numberAsString=Long.toString(number);
        if(message.equals("")&&numberAsString.length()!=10){
            System.out.println("Message cannot be null");
            System.out.println("Invalid Number");
            return 0;
        }
        else if(message.equals("")){
            System.out.println("Message cannot be null");
            return 0;
        }
        else if(numberAsString.length()!=10||numberAsString.contains("[a-zA-Z]+")){
            System.out.println("Invalid Number");
            return 0;
        }
        else
            return 1;
    }
    public String validate(String dateAndTime,String dateFormat){  //Validation date and time
        String pattern="yyyy-MM-dd hh:mm a",finalDate=null;
        Date date;
        if(dateAndTime == null) {
            return null;
        }
        try {
            if (new SimpleDateFormat(dateFormat).parse(dateAndTime).before(new Date())){
                return null;
            }
        } catch (ParseException e) {

        }
            try {
                SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
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
    public String checkDate(String dateGiven,String dateFormat){  //Validate date
        String pattern="yyyy-MM-dd",finalDate=null;
        Date date;
        if(dateGiven == null) {
            return null;
        }
        try {
            SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
            date = sdf.parse(dateGiven);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            finalDate = simpleDateFormat.format(date);
        } catch (ParseException e) {

        }
        return finalDate;
    }
}
