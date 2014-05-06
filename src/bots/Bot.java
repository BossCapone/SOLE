package bots;

import interperter.Message;

import java.util.HashMap;

public interface Bot {
	/* States and members
	 * String botID;
	 * String botType;
	*/
	
	// initialize the bot for use
	void init();
	void init(HashMap<String, String> args);
	
	// return the bots unique identifier
	String getBotID();
	
	// Return the bot type as a string
	String getBotType();
	
	// Process input and provide a response
	String processInput(String input);
	String processInput(Message input);
	//Message processInput(Message input);
	void setUser(String text);
	
}
