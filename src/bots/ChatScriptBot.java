package bots;

import interperter.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class ChatScriptBot implements Bot {

	 char nullChar = (char) 0;
	 String botName = "";
	 String botID = "";
	 String botType = "ChatScript Bot";
	 String userName = "guest"; // or take as input
	 // networking properties:
     String host = "localhost";
     int port = 1024;
	 
	 @Override
	public void init() {
	  System.out.println("ChatScript Bot init()...");
	  System.out.println("got back:" + doMessage(nullChar+"1"+nullChar+nullChar));
	  System.out.println("now starting conversation..." + doMessage(userName+nullChar+nullChar+nullChar));
	  System.out.println("conversation started with default bot as " + userName);
	 } 
	 
	 @Override
	public void init(HashMap<String, String> args) {
			init();
		}
	 
	 @Override
	public String processInput(String input) {
	  return doMessage(/*default+*/nullChar+nullChar+input+nullChar);
	 }

	//public String processInput(Message input) {
	//	return doMessage(input.toString());
	//}
	 
	private String doMessage(String mess)
	 {
	  Socket echoSocket;
	  String resp = "";
	  
	  try {
	   echoSocket = new Socket(host, port);
	   PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
	   BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
	   out.println(mess);
	   resp = in.readLine();
	   echoSocket.close();
	  } catch (IOException e) {
	   e.printStackTrace();
	   System.out.println("Error: " + e.getMessage());
	  }

	  return resp;
	 }
	
	 @Override
	public String getBotType() {
	  return botType;
	 }

	@Override
	public String getBotID() {
		return botID;
	}
	
	public void setBotID(String id) {
		botID = id;
	}
	
	public void setUser(String user) {
		userName = user;
	 }

	@Override
	public String processInput(Message input) {
		// TODO Auto-generated method stub
		return null;
	} 

	




	} 