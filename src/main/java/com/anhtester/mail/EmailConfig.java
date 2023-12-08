/*
 * Copyright (c) 2022.
 * Automation Framework Selenium - Anh Tester
 */

package com.anhtester.mail;

import static com.anhtester.constants.FrameworkConstants.REPORT_TITLE;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {

    //Remember to create an app password (App Password) for Gmail before sending
    //If you use Hosting's email, it's normal
    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "jmrd666@gmail.com";
    public static final String PASSWORD = "Jmrd5466.";

    public static final String[] TO = {"jmrd66@mailinator.com"};
    public static final String SUBJECT = REPORT_TITLE;
}