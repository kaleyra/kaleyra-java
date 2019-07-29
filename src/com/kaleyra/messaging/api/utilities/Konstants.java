/*
 * Copyright 2019 Kaleyra. All Rights Reserved.
 * Author :  Viram Jain
 */

package com.kaleyra.messaging.api.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class Konstants {
    public static String senderID,apiKey,baseURL;
    private static Properties p = new Properties();

    /**
     * Constructor to configure values from file named "SMS.properties"
     */
    public Konstants(){
        FileReader reader = null;
        try {
            reader = new FileReader("SMS.properties");
        } catch (FileNotFoundException e) {
            System.out.println("Properties file not found");
        }
        try {
            p.load(reader);
        } catch (IOException e) {

        }
        senderID  =  p.getProperty("senderID");
        apiKey  =  p.getProperty("APIKey");
        baseURL = p.getProperty("URL");
    }
}
