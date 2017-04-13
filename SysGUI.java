import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.text.*;

public class SysGUI
{
	JFrame frame;
	private JPanel currentPage;		// pointer to the current page
	private static final Database database = new Database();	// constant because there is only one		
	private UserAccount account;	
	private boolean lang;	// determines whether EN or FR
	private final boolean EN = true;
	private final boolean FR = false;
	private String defaultTxtMsg;
	
	private JPanel langScreen, loginScreen, mainScreen, reportScreen, suggestScreen;
	private JButton btnEN, btnFR, btnLogin, btnProblem,	btnSuggest, btnSign, btnSub;
	
	private JComboBox cmbPrbs;
	private JTextArea txtProb;
	private JTextField txtUser, txtAdd;
	private JPasswordField txtPass;
	
	private ActionListener action;
	private FocusListener textbox;
		
	
	public SysGUI()
	{
		frame = new JFrame();
		currentPage = langScreen;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setTitle("CYPRESS");
		action = new ButtonListener();
		textbox = new TextboxListener();
		lang = EN;
		displayLangScreen();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	// universal ButtonListener
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			// applies if on lang page
			if(currentPage == langScreen)
			{
				// change the language
				if(event.getSource() == btnEN)
				{
					lang = EN;
				}
				else if(event.getSource() == btnFR)
				{
					lang = FR;
				}
				// go to next screen
				displayLoginScreen();
			}
			// applies if on login page
			else if(currentPage == loginScreen)
			{
				if(event.getSource() == btnLogin)
				{
					// creates an account and adds it to the database
					account = new UserAccount();
					String username = txtUser.getText();
					// username should be NULL if nothing is typed in
					if(username.equals(defaultTxtMsg))
					{
						username = "";
					}
					String password = new String(txtPass.getPassword());
					if(account.checkValidName(username))
					{
						account.setUsername(username);
					}
					if(account.checkValidPass(password))
					{
						account.setPassword(password);
					}
					/* 
					// debug info START --->
					System.out.println(account.toString());
					System.out.println("ACCOUNTS IN DATABASE:");
					Iterator<UserAccount> iterator = database.getAllUsers().iterator();
					while(iterator.hasNext())
					{
						iterator.next().getUserName();
					} 
					// <--- debug info END
					*/
					if(account.checkValidName(username) && account.checkValidPass(password))
					{
						// if account successfully made, go to next screen
						account.loginUser();
						database.addUser(account);
						// go to the next screen
						displayMainScreen();
					}
				}
			}
			else if(currentPage == mainScreen)
			{
				if(event.getSource() == btnProblem)
				{
					displayReportScreen();
				}
				else if(event.getSource() == btnSuggest)
				{
					displaySuggestScreen();
				}
				else if(event.getSource() == btnSign)
				{
					account.logoutUser();
					displayLoginScreen();
				}
			}
			else if(currentPage == suggestScreen)
			{
				if(event.getSource() == btnSub)
				{
					String sub;
					if (lang == FR)
					{
						sub = "La soumission a "+"\u00e9"+"t"+"\u00e9"+" re"+"\u00e7"+"ue";
					}
					else
					{
						sub = "Submission has been received";
					}
					JOptionPane.showMessageDialog(frame, sub, "InfoBox:" , JOptionPane.INFORMATION_MESSAGE);
					displayMainScreen();
				}
			}
			else if(currentPage == reportScreen)
			{
				
			}
		}
	}
	
	// universal TextboxListener
	class TextboxListener implements FocusListener
	{
		public void focusGained(FocusEvent event)
		{		
			// grey out all textbox components
			if(event.getSource() instanceof JTextComponent)
			{
				if(((JTextComponent)event.getSource()).getText().equals(defaultTxtMsg))
				{	
					((JTextComponent)event.getSource()).setText("");
					((JTextComponent)event.getSource()).setForeground(Color.BLACK);
				}
			}
		}
		
		public void focusLost(FocusEvent event)
		{
			// grey out all textbox components
			if(event.getSource() instanceof JTextComponent)
			{
				if(((JTextComponent)event.getSource()).getText().equals(defaultTxtMsg))
				{	
					((JTextComponent)event.getSource()).setText(defaultTxtMsg);
					((JTextComponent)event.getSource()).setForeground(Color.GRAY);
				}
			}
		}
	}
	
	// displays the page for the langScreen
	private void displayLangScreen()
	{
		langScreen = new JPanel();
		currentPage = langScreen;
		// labels
		JLabel lblCYPRESS = new JLabel();
		lblCYPRESS.setText("CYPRESS");
		lblCYPRESS.setFont(new Font("Serif", Font.BOLD, 30));
		lblCYPRESS.setBounds(125,50,200,50);
		JLabel lblToronto = new JLabel();
		lblToronto.setText("City of Toronto");
		lblToronto.setBounds(150,250,100,25);
		langScreen.add(lblCYPRESS);
		langScreen.add(lblToronto);
	
		// buttons
		btnEN = new JButton("English");
		btnEN.setBounds(50,300,80,25);
		btnFR = new JButton("Fran"+"\u00e7"+"ais");
		btnFR.setBounds(250,300,90,25);
		btnEN.addActionListener(action);
		btnFR.addActionListener(action);
		
		langScreen.add(btnEN);
		langScreen.add(btnFR);
		langScreen.setLayout(null);
		frame.setContentPane(currentPage);
		frame.validate();
	}
	
	// displays the page for the loginScreen
	private void displayLoginScreen()
	{
		loginScreen = new JPanel();
		loginScreen.setLayout(null);
		// Titles
		JLabel lblTitle = new JLabel();
		lblTitle.setBounds(140,50,150,50);
		JLabel lblGreetings = new JLabel();
		lblGreetings.setBounds(155,75,250,50);
		// Buttons
		btnLogin = new JButton();
		btnLogin.addActionListener(action);
		btnLogin.setBounds(150,300,100,30);
		// Textboxes
		txtUser = new JTextField(26);		// limits number of chars to 26 (length of textbox)
		txtUser.setBounds(115,150,175,25);
		txtUser.setForeground(Color.GRAY);
		txtUser.addFocusListener(textbox);
		txtPass = new JPasswordField("",26);
		txtPass.setBounds(115,200,175,25);
		if(lang == FR)
		{
			lblTitle.setText("Bienvenue "+"\u00e0"+" CYPRESS!");
			lblGreetings.setText("Connectez-vous pour commencer");
			lblGreetings.setBounds(110,75,250,50);
			defaultTxtMsg = "Entrez votre nom d'utilisateur";
			txtUser.setText(defaultTxtMsg);
			btnLogin.setText("S'identifier");
		}
		else
		{
			lblTitle.setText("Welcome To CYPRESS!!");
			lblGreetings.setText("Sign in to start");
			btnLogin.setText("Log In");
			defaultTxtMsg = "Enter your Username";
			txtUser.setText(defaultTxtMsg);
			;
			txtUser.setBounds(115,150,175,25);
		}
		// adding to frame
		loginScreen.add(lblGreetings);
		loginScreen.add(lblTitle);
		loginScreen.add(btnLogin);
		loginScreen.add(txtUser);
		loginScreen.add(txtPass);
		loginScreen.setLayout(null);
		// replacing frame content
		currentPage = loginScreen;
		frame.setContentPane(currentPage);
		frame.validate();
	}
	
	// displays the page for the mainScreen
	private void displayMainScreen()
	{
		mainScreen = new JPanel();
		mainScreen.setLayout(null);
		//Titles
		JLabel setMTitle = new JLabel();
		setMTitle.setText("Select an Action");
		setMTitle.setBounds(155,50,150,50);
		JLabel setMMsg= new JLabel("Welcome "+account.getUserName()+"!!");
		setMMsg.setBounds(145,25,150,50);
		//Buttons
		btnProblem = new JButton();
		btnProblem.setBounds(115,150,175,25);
		btnSuggest = new JButton();
		btnSuggest.setBounds(115,200,175,25);
		btnSign = new JButton();
		btnSign.setBounds(115,250,175,25);
		if(lang == FR)
		{
			setMTitle.setText("Choisissez une action");
			setMTitle.setBounds(145,50,150,50);
			setMMsg.setText("Bienvenue "+account.getUserName()+"!!");
			btnProblem.setText("Signaler un probl"+"\u00e9"+"me");
			btnSuggest.setText("Ajoutez une suggestion");
			btnSign.setText("D"+"\u00e9"+"connexion");
		}
		else
		{
			btnProblem.setText("Report a problem");
			btnSuggest.setText("Add a suggestion");
			btnSign.setText("Sign out");
		}
		
		// displaying in frame
		mainScreen.add(setMTitle);
		mainScreen.add(setMMsg);
		mainScreen.add(btnSign);
		mainScreen.add(btnSuggest);
		mainScreen.add(btnProblem);
		// adding ActionListeners
		btnProblem.addActionListener(action);
		btnSuggest.addActionListener(action);
		btnSign.addActionListener(action);
		// replacing frame content
		currentPage = mainScreen;
		frame.setContentPane(currentPage);
		frame.validate();
	}
	
	public void displayReportScreen()
	{
		reportScreen = new JPanel();
		reportScreen.setLayout(null);
		//textcombo
		String [] probStrings = {"","Utility failures","Potholes","City Property Vandalism","Eroded Streets",
		"Tree Collapse","Mould and Spore Growth","Garbage or any Other Road Blocking Objects"};
		cmbPrbs = new JComboBox(probStrings);
		cmbPrbs.setBounds(50,160,300,25);
		reportScreen.add(cmbPrbs);
		//textbox
		txtAdd = new JTextField();
		txtAdd.setText("Enter the Address");
		txtAdd.setForeground(Color.GRAY);
		txtAdd.setBounds(50, 110, 300, 25);
		//labels
		JLabel lblCyp = new JLabel();
		lblCyp.setText("Cypress Systems");
		lblCyp.setBounds(130,35,175,40);
		lblCyp.setFont(new Font("Dialog", Font.BOLD, 15));
		JLabel lblAdd = new JLabel();
		lblAdd.setText("Enter the Address here:");
		lblAdd.setBounds(50,90,175,25);
		JLabel lblProb = new JLabel();
		lblProb.setText("Select the Problem here:");
		lblProb.setBounds(50,135,175,25);
		//buttons
		btnSub = new JButton();
		btnSub.setText("Submit");
		btnSub.setBounds(110, 250, 175, 25);

		reportScreen.add(txtAdd);
		reportScreen.add(lblCyp);
		reportScreen.add(lblAdd);
		reportScreen.add(lblProb);
		reportScreen.add(btnSub);

		currentPage = reportScreen;
		frame.setContentPane(currentPage);
		frame.validate();

	}
	
	public void displaySuggestScreen()
	{
		suggestScreen = new JPanel();
		suggestScreen.setLayout(null);
		//textArea
		txtProb = new JTextArea(5,30);
		txtProb.setForeground(Color.GRAY);
		txtProb.setBounds(50,160,300,125);
		Border border = BorderFactory.createLineBorder(Color.BLACK,1);
		txtProb.setBorder(border);
		//labels
		JLabel lblCyp1 = new JLabel();
		lblCyp1.setBounds(80,35,275,40);
		lblCyp1.setFont(new Font("Dialog", Font.BOLD, 30));
		JLabel lblsugg = new JLabel();
		lblsugg.setBounds(50,135,175,25);
		//buttons
		btnSub = new JButton();
		btnSub.setBounds(110, 300, 175, 25);
		
		if(lang == FR)
		{
				defaultTxtMsg = "Ajouter une suggestion ici";
				txtProb.setText(defaultTxtMsg);
				lblCyp1.setText("Syst"+"\u00e8"+"me CYPRESS");
				lblsugg.setText("Bo"+"\u00ee"+"te "+"\u00e0"+" suggestion:");
				btnSub.setText("Soumettre");
		}
		else
		{
			defaultTxtMsg = "Add a Suggestion";
			txtProb.setText(defaultTxtMsg);
			lblCyp1.setText("Cypress Systems");
			lblsugg.setText("Suggestion Box : ");
			btnSub.setText("Submit");
		}

		suggestScreen.add(txtProb);
		suggestScreen.add(lblCyp1);
		suggestScreen.add(lblsugg);
		suggestScreen.add(btnSub);
		
		btnSub.addActionListener(action);
		txtProb.addFocusListener(textbox);
		
		currentPage = suggestScreen;
		frame.setContentPane(currentPage);
		frame.validate();
	
	}
	
	
	
	public static void main(String[] args)
	{
		SysGUI sys = new SysGUI();
	}
}