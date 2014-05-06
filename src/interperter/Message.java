package interperter;

public class Message {
/*
 * ******************************************************************************
 * 	File: Message.java
 * 	Author: Stephen Virgil Jr.
 * 			(c) Ganguro Studios, 2014
 * 
 * 	Description: 
 * 		A message object for handling ChatScript protocol 
 * 		and sending messages to programs using CharScript from Java
 * 		supports message framework. 
 * 			* User address - the location of the user sending the message
 * 			* BotName - The bot addressed to receive the message
 * 			* Message - The message to be received  	 
 * 
 * 		ChatScript uses null terminates strings for its operation. Java strings
 * 		 are not null terminated which leads to protocol errors that cause runtime
 * 		 errors in the Java environment. 
 * 
 * 	TODO:
 * 		Implement out-of-band communications and data support
 * 		The out of band information encased in [ ] passed with the message, use for chatscript and abstract communication
 * *****************************************************************************
 */
	
	public static final String Ip = ".";
	public static final String guest = "guest";
	public static final char nullChar = (char) 0;

	
	// From
	String sourceId = "";
	String sourceIp = "localhost";
	
	// To
	String destinationId = "";
	String destinationIp = "localhost";
	
	// Message 
	String outOfBandData = "";
	String message = ""+nullChar;
	int portId = 1024;
	
	
	public Message() {
		sourceId = "guest";
		
	}
	public Message(String mess) { 
		sourceId = Ip;
		destinationId = "";
		message = mess;
	} 
	public Message(String username, String bot, String text) {
		sourceId = username;
		destinationId = bot;
		message = text;
	}

	
	
	// address to sender
	public String getSender() {
		return sourceId;
	}
	public void setSender(String Id) {
		sourceId = Id;
	}
	public String getHostIp() {
		return sourceIp;
	}
	public void setHostIp(String ip) {
		sourceIp = ip;
	}
	
	
	// address to receiving bot
	public String getReciever() {
		return destinationId;
	}
	public void setReciever(String Id) {
		destinationId = Id;
	}
	public String getRecieverIp() {
		return destinationIp;
	}
	public void setRecieverIp(String ip) {
		destinationIp = ip;
	}

	
	// addressing message 
	public static Message ping() {
		return new Message("","1","");
	}
	public String getText() {
		return message;
	}
	public void setText(String text) {
		message = text;
	}
	public int getPort() {
		return portId;
	}
	public void setPort(int port) {
		portId = port;
	}

	
	// output 
	public String toString() {
		return  sourceId+nullChar+ 
				destinationId+nullChar+ 
				message+nullChar;
	}
}
