package interfaces;

import interperter.Message;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import bots.Bot;
import bots.ChatScriptBot;
import bots.EchoBot;
import bots.NAVI;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NAVIChat extends javax.swing.JFrame implements ActionListener, ItemListener {
	private JLabel jLabel1;
	private JButton jButton1;
	private JLabel jLabel2;
	private JTextField jTextField2;
	private JComboBox jComboBox1;
	private JButton jButton2;
	private JTextArea jTextArea1;
	private JTextField jTextField1;
	public Bot chatBot;
	
	char nullChar = (char) 0;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NAVIChat inst = new NAVIChat();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NAVIChat() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("NAVI Chat");
				jLabel1.setBounds(12, 6, 79, 23);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Send");
				jButton1.setBounds(12, 473, 70, 28);
				jButton1.addActionListener(this);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(87, 473, 270, 28);
				jTextField1.setText("hello");
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(getJTextArea1());
				jTextArea1.setText("Log");
				jTextArea1.setBounds(12, 35, 412, 363);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Clear");
				jButton2.setBounds(12, 405, 70, 28);
				jButton2.addActionListener(this);
			}
			{
				ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] { "NoBot", "EchoBot", "ChatScriptBot", "NAVI" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(409, 404, 130, 28);
				jComboBox1.addItemListener(this);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(getJTextField2());
				jTextField2.setText("guest");
				jTextField2.setBounds(424, 4, 115, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Username");
				jLabel2.setBounds(330, 7, 82, 21);
			}
			pack();
			this.setSize(563, 559);
			
			
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JTextArea getJTextArea1() {
		return jTextArea1;
	}
	
	public JTextField getJTextField2() {
		return jTextField2;
	}

	/*
	 * Custom Methods for the Chat interface
	 */
	
	public void display(String s) {
		jTextArea1.setText(jTextArea1.getText() +"\n"+ s);
	}
	public void log(String s) {
		System.out.println(s);
	}
	 public void clear()
	 {
		 jTextArea1.setText("");
	 }
	/*
	 *
	 */
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("Send")) { // USER hit Send. Display the message
			// Log user message
			String user = getJTextField2().getText();
			String message = jTextField1.getText();
			
			// Display to user
			display(user+ ": " + message);
			log("user ["+user+"] said ["+message+"]");
			
			//log bot message if were talking to a bot 
			if(chatBot != null) {
				String bot = chatBot.getBotType();
				Message usrMsg = new Message();
				usrMsg.setSender(user);
				usrMsg.setText(message);
				
				// Send to bot
				//message = chatBot.processInput( usrMsg.toString() );
	
				
				message = chatBot.processInput(message);
				
				display(bot +": "+ message);
				log("bot ["+bot+"] said ["+message+"]");
				
			}
		}
		
		if(ae.getActionCommand().equals("Clear")) {
			log("screen cleared");
			clear();
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent i) {
		// TODO Auto-generated method stub
		if(i.getSource() == jComboBox1) {
			// create and init a chat bot
			
			if(jComboBox1.getSelectedIndex() == 0) { // empty bot
				chatBot = null;
				log("No Bot init()...");
			}
			if(jComboBox1.getSelectedIndex() == 1) { // init echo bot
				chatBot = new EchoBot();
				chatBot.init();
			}	
			if (jComboBox1.getSelectedIndex() == 2) { // init chatscript bot
				chatBot = new ChatScriptBot();
				chatBot.setUser(getJTextField2().getText());
				chatBot.init();
			}
			if(jComboBox1.getSelectedIndex() == 3) { // init NAVI
				//chatBot = new NAVI();
				//chatBot.init();
				
			}

		}
	}
	
	
}
