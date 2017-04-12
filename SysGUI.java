import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
	private JButton btnEN, btnFR, btnLogin, btnProblem,	btnSuggest, btnSign, btnSub, btnStat, btnSub1;
	
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
		frame.setTitle("Cypress");
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
					boolean isSetup = false;
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
					if(account.checkValidName(username) && account.checkValidPass(password))
					{
						isSetup = true;
					}
					System.out.println(account.toString());
					if(isSetup)
					{
						// if account successfully made, go to next screen
						database.addUser(account);
						// go to the next screen
						displayMainScreen();
					}
				}
			}
		}
	}
	
	// universal TextboxListener
	class TextboxListener implements FocusListener
	{
		public void focusGained(FocusEvent event)
		{
			if(currentPage == loginScreen)
			{
				if(event.getSource() == txtUser)
				{
					if(txtUser.getText().equals(defaultTxtMsg))
					{	
						txtUser.setText("");
						txtUser.setForeground(Color.BLACK);
					}
				}
			}
		}
		
		public void focusLost(FocusEvent event)
		{
			if(currentPage == loginScreen)
			{
				if(event.getSource() == txtUser)
				{
					if(txtUser.getText().equals(""))
					{	
						txtUser.setText(defaultTxtMsg);	
						txtUser.setForeground(Color.GRAY);
					}
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
		JLabel lblCYPRESS = new JLabel("CYPRESS");
		lblCYPRESS.setFont(new Font("Serif", Font.BOLD, 30));
		lblCYPRESS.setBounds(125,50,200,50);
		JLabel lblToronto = new JLabel("City of Toronto");
		lblToronto.setBounds(150,250,100,25);
		langScreen.add(lblCYPRESS);
		langScreen.add(lblToronto);
	
		// buttons
		btnEN = new JButton("English");
		btnEN.setBounds(50,300,80,25);
		btnFR = new JButton("French");
		btnFR.setBounds(250,300,80,25);
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
		btnLogin.setBounds(115,300,175,50);
		// Textboxes
		txtUser = new JTextField(26);		// limits number of chars to 26 (length of textbox)
		txtUser.setBounds(115,150,175,25);
		txtUser.setForeground(Color.GRAY);
		txtUser.addFocusListener(textbox);
		txtPass = new JPasswordField("",26);
		txtPass.setBounds(115,200,175,25);
		if(lang == FR)
		{
			lblTitle.setText("Bienvenue à CYPRESS!");
			lblGreetings.setText("Connectez-vous pour commencer");
			lblGreetings.setBounds(110,75,250,50);
			defaultTxtMsg = "Entrez votre nom d'utilisateur";
			txtUser.setText(defaultTxtMsg);
			btnLogin.setText("S'identifier");
		}
		else
		{
			lblTitle.setText("Welcome To Cypress!!");
			lblGreetings.setText("Sign in to start");
			btnLogin.setText("Log In");
			defaultTxtMsg = "Enter your Username";
			txtUser.setText(defaultTxtMsg);
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
		JLabel setMTitle = new JLabel("Select an Action");
		setMTitle.setBounds(155,50,150,50);
		JLabel setMMsg= new JLabel("Welcome USERNAME!!");
		setMMsg.setBounds(145,25,150,50);
		mainScreen.add(setMTitle);
		mainScreen.add(setMMsg);
		
		//Buttons
		btnProblem = new JButton("Report a Problem");
		btnProblem.setBounds(115,100,175,25);
		btnSuggest = new JButton("Add a Suggestion");
		btnSuggest.setBounds(115,150,175,25);
		btnStat = new JButton("Check Status");
		btnStat.setBounds(115,200,175,25);
		btnSign = new JButton("Sign Out");
		btnSign.setBounds(115,250,175,25);
		mainScreen.add(btnSign);
		mainScreen.add(btnSuggest);
		mainScreen.add(btnProblem);
		mainScreen.add(btnStat);
	}
	
	public static void main(String[] args)
	{
		SysGUI sys = new SysGUI();
	}
}