import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;




public class CypressFrame {
	
	private JFrame frame;
	
	//True if English(default), False if French
	boolean language = true;
	
	private JPanel
	//Screens
		langScreen,
		logScreen,
		mainScreen,
		repScreen,
		sugScreen;
	
	private JButton
	//buttons
		btnEN,
		btnFR,
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
		txtAdd;
	

	
	public CypressFrame(){
	
	frame = new JFrame();
	
//Language Screen
	langScreen = new JPanel();
	langScreen.setLayout(null);
	JLabel lblCYPRESS = new JLabel("CYPRESS");
	lblCYPRESS.setFont(new Font("Serif", Font.BOLD, 30));
	lblCYPRESS.setBounds(125,50,200,50);
	JLabel lblToronto = new JLabel("City of Toronto");
	lblToronto.setBounds(150,250,100,25);
	langScreen.add(lblCYPRESS);
	langScreen.add(lblToronto);
	
	//Buttons
	btnEN = new JButton("English");
	btnEN.setBounds(50,300,80,25);
	btnFR = new JButton("French");
	btnFR.setBounds(250,300,80,25);
	langScreen.add(btnEN);
	langScreen.add(btnFR);
		
//LogScreen	
	//panel
	logScreen = new JPanel();
	logScreen.setLayout(null);
	//Titles
	JLabel lblTitle = new JLabel("Welcome To Cypress!!");
	lblTitle.setBounds(140,50,150,50);
	JLabel lblGreetings = new JLabel("Sign in to start");
	lblGreetings.setBounds(155,75,250,50);
	logScreen.add(lblGreetings);
	logScreen.add(lblTitle);
	
	//Butttons
	btnLogin = new JButton("Log In");
	btnLogin.setBounds(115,300,175,25);
	logScreen.add(btnLogin);
	
	//Textboxes
	txtUser = new JTextField("Enter your Username");
	txtUser.setBounds(115,150,175,25);
	txtUser.setForeground(Color.GRAY);
	JPasswordField txtPass= new JPasswordField("");
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
	txtAdd  = new JTextField("Enter the Address");
	txtAdd.setForeground(Color.GRAY);
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
	txtProb.setForeground(Color.GRAY);
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
		
	btnEN.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			frame.setContentPane(logScreen);
			frame.validate();
		}
	});
	
	btnFR.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			language = false;
			frame.setContentPane(logScreen);
			//Login screen
			lblTitle.setText("Bienvenue à CYPRESS!");
			lblGreetings.setText("Connectez-vous pour commencer");
			lblGreetings.setBounds(110,75,250,50);
			txtUser.setText("Entrez votre nom d'utilisateur");
			btnLogin.setText("S'identifier");
			frame.validate();
		}
	});
		
	btnLogin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			frame.setContentPane(mainScreen);
			if(!language){
				setMTitle.setText("Choisissez une action");
				setMTitle.setBounds(145,50,150,50);
				setMMsg.setText("Bienvenue USERNAME");
				btnProb.setText("Signaler un problème");
				btnSugg.setText("Ajoutez une suggestion");
				btnStat.setText("Vérifiez l'état");
				btnSign.setText("Déconnexion");
			}
			frame.validate();
			}
		});
	
	btnProb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			frame.setContentPane(repScreen);
			if(!language){
				lblCyp.setText("Système CYPRESS");
				lblAdd.setText("Entrez l'adresse ici");
				txtAdd.setText("Entrez l'adresse");
				lblProb.setText("Sélectionnez le problème ici:");
				btnSub.setText("Soumettre");
			}
			frame.validate();
			}
		});
	
		
	
	btnSugg.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			frame.setContentPane(sugScreen);
			if(!language){
				lblCyp1.setText("Système CYPRESS");
				lblsugg.setText("Boîte à suggestion:");
				txtProb.setText("Ajouter une suggestion ici");
				btnSub1.setText("Soumettre");
			}
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
			if (!language) sub = "Soumission envoyée";
			JOptionPane.showMessageDialog(null, sub, "InfoBox:" , JOptionPane.INFORMATION_MESSAGE);
			frame.setContentPane(mainScreen);
			frame.validate();
			}
		});
	
	
	btnSub1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e ){
			String sub = "Submission has been received";
			if (!language) sub = "La soumission a été reçue";
			JOptionPane.showMessageDialog(null, sub, "InfoBox:" , JOptionPane.INFORMATION_MESSAGE);
			frame.setContentPane(mainScreen);
			frame.validate();
			}
		});

	
	

//MouseListener	
	MouseListener m1 = new MouseListener(){
        public void mouseReleased(MouseEvent e) {	
     
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
            txtUser.getCaret().setVisible(false);
   
        }
        public void mouseEntered(MouseEvent e) {
            txtAdd.setText("Enter the Address");
            txtProb.setText("Add a Suggestion");
            txtUser.getCaret().setVisible(true);
            txtProb.getCaret().setVisible(true);
            txtAdd.getCaret().setVisible(true);
        }
        public void mouseClicked(MouseEvent e) {
        	txtUser.setText("");
        }
	};
	
	MouseListener m2 = new MouseListener(){
        public void mouseReleased(MouseEvent e) {	
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
            txtAdd.getCaret().setVisible(false);
        }
        public void mouseEntered(MouseEvent e) {
        	txtUser.setText("Enter your Username");
            txtProb.setText("Add a Suggestion");
            txtUser.getCaret().setVisible(true);
            txtProb.getCaret().setVisible(true);
            txtAdd.getCaret().setVisible(true);
        }
        public void mouseClicked(MouseEvent e) {
        	txtAdd.setText("");
        }
	};
	
	MouseListener m3 = new MouseListener(){
        public void mouseReleased(MouseEvent e) {	
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
            txtProb.getCaret().setVisible(false);           
        }
        public void mouseEntered(MouseEvent e) {
        	txtUser.setText("Enter your Username");
            txtAdd.setText("Enter the Address");
            txtUser.getCaret().setVisible(true);
            txtProb.getCaret().setVisible(true);
            txtAdd.getCaret().setVisible(true);
        }
        public void mouseClicked(MouseEvent e) {
            txtProb.setText("");
        }
	};
	
	txtUser.addMouseListener(m1);
	txtAdd.addMouseListener(m2);
	txtProb.addMouseListener(m3);
	}
	

	public String[] pack(String user, String pass, int tele, String addr, String email){
		String[] userPackage = new String[5];
		userPackage[0] = user;
		userPackage[1] = pass;
		userPackage[2] = Integer.toString(tele);
		userPackage[3] = addr;
		userPackage[4] = email;
		return userPackage;
	}
	
	
	
	


public static void main(String[] args) {
	 new CypressFrame();
	}
}

