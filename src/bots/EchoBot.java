package bots;

import interperter.Message;

import java.util.HashMap;

public class EchoBot implements Bot {

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Echo Bot init()...");
	}
	
	@Override
	public void init(HashMap<String, String> args) {
		init();
	}
	
	@Override
	public String getBotType() {
		// TODO Auto-generated method stub
		return "Echo Bot";
	}

	@Override
	public String processInput(String input) {
		// TODO Auto-generated method stub
		return "You said: "+input;
	}

	@Override
	public String getBotID() {
		// TODO Auto-generated method stub
		return "echo001";
	}

	@Override
	public void setUser(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String processInput(Message input) {
		// TODO Auto-generated method stub
		return null;
	}

}
