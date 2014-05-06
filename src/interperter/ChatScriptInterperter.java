package interperter;


public interface ChatScriptInterperter {

	
	// default call to init the chat script system
	void initSystem();

	// close the CS system to reduce work load
	void closeSystem();


	// default methods for communicating with ChatScript
	void performChat(String to, String from, String message);
	void performChat(String to, String from, String message, String ip);
	void performChat(String to, String from, String message, String ip, String output);

	// protocols based methods for communication with CS
	void performChat(Message message);
	
	// definine the necessary paths for operation
	void setChatScriptPath(String path);
	void setSystemPath(String path);
	void setReadOnlyPath(String path);
	void setOutputPath(String path);

}
/*
 * MIND NOTES
 * Mind file system paths:
 *  CSpath = path for the CS application
 *  brain = path for files that never change
 *  knowledge = path for files that can be read and changed by download
 *  memory= path for files that the CS engine may output
 *  
 *  Files that may never change:
 *   system files
 *   dictonary files-
 *   framework files
 *  
 *  Files that are read only and downloadable:
 *   downloads
 *   application files
 *   conversation files
 *   script files
 *   
 *  Files that are CS engine output:
 *   output files
 *   user files and logs
 *   
 * Social Systems
 * The mind should be able to create local CS servers wherever it exists and operate from these servers.
 *   
*/