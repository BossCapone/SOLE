/*
 * ******************************************************************************
 * 	File: NAVICommandLineInterface.java
 * 	Author: Stephen Virgil Jr.
 * 			(c) Ganguro Studios, 2014
 * 
 * 	Description: 
 * 		
 * 
 * *****************************************************************************
 */
package interfaces;
import bots.NAVI;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import interperter.Message;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class BotCommandLineInterface extends javax.swing.JFrame implements ActionListener, KeyListener {
	private JTextField jTextField1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JTextField jTextField3;
	private JButton jButton1;
	private JTextField jTextField2;
	private JButton jButton2;
	private JLabel jLabel8;
	private JSeparator jSeparator1;
	private JLabel jLabel1;

	private boolean syslog = true;
	private boolean connected = false;
	private NAVI navi;
	private String mode = "cmd";
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BotCommandLineInterface inst = new BotCommandLineInterface();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BotCommandLineInterface() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, new AnchorConstraint(901, 779, 971, 24, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField1.setPreferredSize(new java.awt.Dimension(379, 28));
				jTextField1.setBackground(new java.awt.Color(255,255,255));
				jTextField1.addActionListener(this);
				jTextField1.addKeyListener(this);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, new AnchorConstraint(31, 150, 83, 16, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("username:");
				jLabel1.setPreferredSize(new java.awt.Dimension(67, 21));
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1, new AnchorConstraint(105, 997, 130, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jSeparator1.setPreferredSize(new java.awt.Dimension(501, 10));
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8, new AnchorConstraint(23, 534, 83, 401, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setText("connect");
				jLabel8.setPreferredSize(new java.awt.Dimension(67, 24));
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, new AnchorConstraint(901, 987, 971, 803, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton1.setText("Enter");
				jButton1.setPreferredSize(new java.awt.Dimension(92, 28));
				jButton1.addActionListener(this);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, new AnchorConstraint(122, 975, 872, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(534, 302));
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
					jTextArea1.setEditable(false);
					jTextArea1.setBackground(new java.awt.Color(0,0,0));
					jTextArea1.setForeground(new java.awt.Color(0,255,0));
					jTextArea1.setText("jTextArea1");
				}
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2, new AnchorConstraint(21, 979, 90, 797, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton2.setText("Connect");
				jButton2.setPreferredSize(new java.awt.Dimension(91, 28));
				jButton2.addActionListener(this);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2, new AnchorConstraint(23, 365, 93, 166, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField2.setText("guest");
				jTextField2.setPreferredSize(new java.awt.Dimension(100, 28));
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3, new AnchorConstraint(21, 773, 90, 522, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextField3.setText("localhost");
				jTextField3.setEditable(false);
				jTextField3.setPreferredSize(new java.awt.Dimension(126, 28));
			}
			
			pack();
			this.setSize(578, 450);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton1)
		{
			processText(jTextField1.getText());
			jTextField1.setText("");
		}
		if(e.getSource() == jButton2)
		{
			if(connected)
				disconnect();
			else
				connect();
		}
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
		{
			processText(jTextField1.getText());
			jTextField1.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

/*
 * Custom methods for operation
 * 
 */
	
	private void log(String s) {
		if(syslog)
			System.out.println(s);
		jTextArea1.setText( jTextArea1.getText() + "\n"+ s );
	}
	
	private void processText(String txt) {
		// Check for mode change		
		switch (txt) {
		case ".cmd":
			setCommandPrompt();
			break;
			
		case ".chat":
			setChatPrompt();
			break;
			
		default:
			if(mode == "cmd")
				processCmd(txt);
			if(mode == "chat")
				processChat(txt);
			break;
		}
	}
	
	private void processCmd(String txt) {
		switch (txt) {
		case "cls":
			clear();			
			break;

		
		default:
			log("cmd -> "+txt);
			break;
		}
	}
	
	private void processChat(String txt) {
		if(connected)
		{
			log(jTextField2.getText()+": "+txt);
			log("NAVI: "+ navi.processInput(txt) );
			
		}
		else
			log("Error: not connected to a NAVI");
		
	}
	
	private void setCommandPrompt() {
		mode = "cmd";
		jTextField1.setBackground(new Color(0,0,0));
		jTextField1.setForeground(new Color(0,255,0));
		jTextArea1.setBackground(new Color(0,0,0));
		jTextArea1.setForeground(new Color(0,255,0));
	}
	private void setChatPrompt() {
		mode = "chat";
		jTextField1.setBackground(new Color(255,255,255));
		jTextField1.setForeground(new Color(0,0,255));
		jTextArea1.setBackground(new Color(255,255,255));
		jTextArea1.setForeground(new Color(0,0,255));
	}
	
	private void clear() {
		jTextArea1.setText("");
	}

	private void connect() {
		jTextField3.setEditable(false);
		navi = new NAVI();
		navi.init();
		log("connecting to navi through '"+ jTextField3.getText() +"'...");
		log("pinging NAVI, got back: "+navi.ping() );
		log("init new Conversation()... \n\n"+navi.processMessage(new Message() ));
		
		
		jButton2.setText("Disconnect");
		connected = true;
		setChatPrompt();
	}
	
	private void disconnect() {
		jTextField3.setEditable(true);
		//navi = null;
		log("disconnected from NAVI ");
		jButton2.setText("Connect");
		connected = false;
	}




}
