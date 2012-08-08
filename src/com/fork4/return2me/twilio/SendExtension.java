package com.fork4.return2me.twilio;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;


public class SendExtension {
	static Logger log = Logger.getLogger("SendExtension");
	
    public static void send(TwilioAccount account, String extension, String customerNumber) {
        // Prep the Twilio client
    	TwilioRestClient client = new TwilioRestClient(account.getSid(), account.getToken());

    	// Get the SMS factory  
        SmsFactory smsFactory = client.getAccount().getSmsFactory();

        // Build map of parameters for the message
        Map<String,String> params = new HashMap<String,String>();
        params.put("From", account.getFromNumber());
        params.put("To", customerNumber);
        params.put("Body", "Your Return2Me extension is " + extension + ".  Dial " + account.getFromNumber() + 
        		" and enter this extension to be connected with your representative.");

        try {
            // Send SMS message
            Sms sms = smsFactory.create(params);
            log.fine("Successfully sent SMS: " + sms.getSid());
        }
        catch (TwilioRestException e) {
            e.printStackTrace();
        }
        
    }       
}
