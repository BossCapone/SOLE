package bots;

import interperter.Message;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;


public class NAVI {
/*
 * ******************************************************************************
 * 	File: NAVI.java
 * 	Author: Stephen Virgil Jr.
 * 			(c) Ganguro Studios, 2014
 * 
 * 	Description: 
 * 		
 * 
 * *****************************************************************************
 */
	String botName = "";

	public void init() {
		System.out.println("NAVI Bot init()...");		
	}
	

	public String getBotType() {
		// TODO Auto-generated method stub
		return "NAVI";
	}

	public void setUser(String text) {
		// TODO Auto-generated method stub
		
	}

	public String ping() {
		Message ping = processMessage( Message.ping() );
		return ping.getText();
	}
	
	// Message processing 
	public String processInput(String input) {
		Message out = sendMessage(new Message(input));
		return out.getText();
	}
	public Message processMessage(Message m) {
		return sendMessage(m);
	}
	
	
	//public Message processInput(Message input) {
	//	return sendMessage(input);
	//}
	
	private Message sendMessage(Message message) {
		Socket chatSocket;
		String host = message.getHostIp();
		int port = message.getPort();
		String resp = "";
		
		try {
			chatSocket = new Socket(host, port);
			PrintWriter out = new PrintWriter( chatSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
			out.println(message);
			resp = in.readLine();
			chatSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+ e.getMessage());
		}
		
		// Construct return message
		Message response = new Message();
		
		response.setRecieverIp(host);
		response.setSender(botName);
		response.setText(resp);
		return response;
	}
	
}
