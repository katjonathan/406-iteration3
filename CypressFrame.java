import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;




public class CypressFrame {
	
	private JFrame frame;
	
	private JPanel
	//Screens
		logScreen,
		mainScreen,
		repScreen,
		sugScreen;
	
	private JButton
	//buttons
		btnLogin,
		btnProb,
		btnSign,
		btnSub,
		btnSugg,
		btnStat,
		btnSub1;
	
	private JComboBox
	//comboBox
		cmbPrbs;
	
	private JTextArea
	txtProb;
	
	private JTextField 
	//textFields
		txtUser,
		txtPass,
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
	//textcombo
	String [] probStrings = {"","Utility failures","Potholes","City Property Vandalism","Eroded Streets",
	"Tree Collapse","Mould and Spore Growth","Garbage or any Other Road Blocking Objects"};
	cmbPrbs = new JComboBox(probStrings);
	cmbPrbs.setBounds(50,160,300,25);
	repScreen.add(cmbPrbs);
	//textbox
	txtAdd  = new JTextField("Address ");
	txtAdd.setBounds(50, 110, 300, 25);
	repScreen.add(txtAdd);
	//labels
	JLabel lblCyp = new JLabel("Cypress Systems");
	lblCyp.setBounds(130,35,175,40);
	lblCyp.setFont(new Font("Dialog", Font.BOLD, 15));
	JLabel lblAdd = new JLabel("Enter the Address here:");
	lblAdd.setBounds(50,90,175,25);
	JLabel  lblProb = new JLabel("Select the Problem here:");
	lblProb.setBounds(50,135,175,25);
	repScreen.add(lblCyp);
	repScreen.add(lblAdd);
	repScreen.add(lblProb);
	//buttons
	btnSub = new JButton("Submit");
	btnSub.setBounds(110, 250, 175, 25);
	repScreen.add(btnSub);

//sugScreen
	sugScreen = new JPanel();
	sugScreen.setLayout(null);
	//textArea
	txtProb = new JTextArea("Add a Suggestion", 5,30);
	txtProb.setBounds(50,160,300,125);
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	txtProb.setBorder(border);
	sugScreen.add(txtProb);

	//labels
	JLabel lblCyp1 = new JLabel("Cypress Systems");
	lblCyp1.setBounds(80,35,275,40);
	lblCyp1.setFont(new Font("Dialog", Font.BOLD, 30));
	JLabel lblsugg = new JLabel("Suggestion Box : ");
	lblsugg.setBounds(50,135,175,25);
	sugScreen.add(lblCyp1);
	sugScreen.add(lblsugg);
	//buttons
	btnSub1 = new JButton("Submit");
	btnSub1.setBounds(110, 300, 175, 25);
	sugScreen.add(btnSub1);
	
//frame settings
	frame.add(logScreen);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400,400);
	frame.setTitle("Cypress");
	frame.setResizable(false);
	frame.setVisible(true);
	
//btn actions 	
	btnLogin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			frame.setContentPane(mainScreen);
			frame.validate();
			}
		});
	
	btnProb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			
			frame.setContentPane(repScreen);
			frame.validate();
			}
		});
	
		
	
	btnSugg.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			frame.setContentPane(sugScreen);
			frame.validate();
			}
		});
	
	
	btnSign.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			System.exit(0);
			}
		});
	
	btnSub.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			System.out.println(cmbPrbs.getSelectedItem());
			String sub = "Submission Sent";
			JOptionPane.showMessageDialog(null, sub, "InfoBox:" , JOptionPane.INFORMATION_MESSAGE);
			frame.setContentPane(mainScreen);
			frame.validate();
			}
		});
	
	
	btnSub1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			String sub = "Submission has been received";
			JOptionPane.showMessageDialog(null, sub, "InfoBox:" , JOptionPane.INFORMATION_MESSAGE);
			frame.setContentPane(mainScreen);
			frame.validate();
			}
		});
	

		}
	



public static void main(String[] args) {
	 new CypressFrame();
	}
}