package com.fork4.return2me.twilio;

public class IvrResponse {
	public static String callRedirect(String number) {
		StringBuilder response = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
		response.append("<Response>");
		response.append("<Say>Connecting you to your representative.</Say>");
		response.append("<Dial>+1" + number.replaceAll("-", "") + "</Dial>");
		response.append("</Response>");
		
		return response.toString();
	
	}

	public static String badExtension() {
		StringBuilder response = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
		response.append("<Response>");
		// TODO Don't hard code action URL
		response.append("<Gather action=\"http://return2me.elasticbeanstalk.com/fetch\" numDigits=\"5\" timeout=\"10\" finishOnKey=\"#\">");
		response.append("<Say>Extension not found.</Say>");
		response.append("<Say>Enter the extension for your representative. Press pound to continue.</Say>");
		response.append("</Gather>");
		response.append("<Say>Sorry, I didn't get your response.</Say>");
		response.append("<Redirect>http://return2me.elasticbeanstalk.com/ivr/incoming.xml</Redirect>");
		response.append("</Response>");
		
		return response.toString();
	
	}

}
