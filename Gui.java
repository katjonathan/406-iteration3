import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;




public class CypressFrame  {
	
	private JFrame frame;
	
	private JPanel
		logScreen,
		mainScreen,
		statScreen,
		repScreen; 
	
	private JButton
		btnLogin,
		btnProb,
		btnSugg,
		btnStat,
		btnSign,
		btnSub;
	
	private JTextArea
		txtProb;
	
	private JTextField 
		txtUser,
		txtPass,
		txtSub,
		txtAdd;
	
	private JLabel lblMsg;
	
	public CypressFrame(){
		
	frame = new JFrame();
	
//LogScreen	
	//panel
	logScreen = new JPanel();
	logScreen.setLayout(null);
	//Titles
	JLabel lblTitle = new JLabel("Welcome To Cypress!!");
	lblTitle.setBounds(140,50,150,50);
	JLabel lblGreetings = new JLabel("Sign in to start");
	lblGreetings.setBounds(155,75,250,50);
	lblMsg = new JLabel("Incorrect Log In");
	lblMsg.setBounds(155,250,250,50);
	logScreen.add(lblGreetings);
	logScreen.add(lblTitle);
	
	//Butttons
	btnLogin = new JButton("Log In");
	btnLogin.setBounds(115,300,175,25);
	logScreen.add(btnLogin);
	
	//Textboxes
	txtUser = new JTextField("Username");
	txtUser.setBounds(115,150,175,25);
	txtPass = new JTextField("Password");
	txtPass.setBounds(115,200,175,25);
	logScreen.add(txtUser);
	logScreen.add(txtPass);

//MainScreen
	//panel
	mainScreen= new JPanel();
	mainScreen.setLayout(null);
	//Titles
	JLabel setMTitle = new JLabel("Select an Action");
	setMTitle.setBounds(155,50,150,50);
	JLabel setMMsg= new JLabel("Welcome USERNAME!!");
	setMMsg.setBounds(145,25,150,50);
	mainScreen.add(setMTitle);
	mainScreen.add(setMMsg);
	
	//Buttons
	btnProb = new JButton("Report a Problem");
	btnProb.setBounds(115,100,175,25);
	btnSugg = new JButton("Add a Suggestion");
	btnSugg.setBounds(115,150,175,25);
	btnStat = new JButton("Check Status");
	btnStat.setBounds(115,200,175,25);
	btnSign = new JButton("Sign Out");
	btnSign.setBounds(115,250,175,25);
	mainScreen.add(btnSign);
	mainScreen.add(btnSugg);
	mainScreen.add(btnProb);
	mainScreen.add(btnStat);
		
//repScreen
	repScreen = new JPanel();
	repScreen.setLayout(null);
	//textArea
	txtProb = new JTextArea("Report", 5,30);
	txtProb.setBounds(50,160,300,125);
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	txtProb.setBorder(border);
	repScreen.add(txtProb);
	//textboxes
	txtSub  = new JTextField("Subject");
	txtSub.setBounds(50, 60, 300, 25);
	txtAdd  = new JTextField("Address ");
	txtAdd.setBounds(50, 110, 300, 25);
	repScreen.add(txtSub);
	repScreen.add(txtAdd);
	//labels
	JLabel lblSub = new JLabel("Enter the Subject here:");
	lblSub.setBounds(50,35,175,25);
	JLabel lblAdd = new JLabel("Enter the Address here:");
	lblAdd.setBounds(50,90,175,25);
	JLabel lblProb = new JLabel("Enter your Problem here:");
	lblProb.setBounds(50,135,175,25);
	repScreen.add(lblSub);
	repScreen.add(lblAdd);
	repScreen.add(lblProb);
	//buttons
	btnSub = new JButton("Submit");
	btnSub.setBounds(110, 315, 175, 25);
	repScreen.add(btnSub);
	
	
	
	
	
	
	
	
	//Frame settings default
	frame.add(mainScreen);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400,400);
	frame.setTitle("Cypress");
	frame.setResizable(false);
	frame.setVisible(true);
	
		}
	
	
//Action listeners

	//Clearing Screen
	//frame.getContentPane().removeAll();




public static void main(String[] args) {
	 new CypressFrame();
	}
}