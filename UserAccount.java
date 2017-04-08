import java.util.ArrayList;

/**
 * A UserAccount represents a User (a citizen) that is utilizing
 * the CYPRESS system to submit Reports
 * @author User
 *
 */
public class UserAccount {

	String username;
	String password;
	int telenum;
	String address;
	String email;
	boolean loggedIn;
	ArrayList<Report> reports;
	
	/**
	 * Constructs an empty UserAccount
	 */
	public UserAccount(){
		
		username = "";
		password = "";
		telenum = 0;
		address = "";
		email = "";
		loggedIn = false;
	}
	
	/**
	 * Sets the username of the User
	 * @param name the User's name
	 */
	public boolean setUsername(String name){
		this.username = name;
		return true;
	}
	
	/**
	 * Sets the password of the User
	 * @param pass the User's password
	 */
	public boolean setPassword(String pass){
		this.password = pass;
		return true;
	}
	
	/**
	 * Sets the address of the User
	 * @param addr the User's address
	 */
	public boolean setAddress(String addr){
		this.address = addr;
		return true;
	}
	
	/**
	 * Sets the email of the User
	 * @param mail the User's email
	 */
	public boolean setEmail(String mail){
		this.email = mail;
		return true;
	}
	
	/**
	 * Gets the User's user name
	 * @return the username
	 */
	public String getUserName(){
		return username;
	}
	
	/**
	 * Gets the User's address
	 * @return the address
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * Gets the User's email
	 * @return the email
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * Gets the User's report history
	 * @return the reports made by the user
	 */
	public ArrayList<Report> getReports(){
		return reports;
	}
	
	/**
	 * Checks if the entered username is valid
	 * @param database to check name against
	 * @param name to have validity checked
	 * @return true is username is valid else false
	 */
	boolean checkValidName(Database database, String name){
		if (database.getUser(name)) return false;
		else return true;
	}
	
	/**
	 * Checks if the entered password is valid
	 * @return true if password is valid else false
	 */
	boolean checkValidPass(String pass){
		return true;
	}
	
	/**
	 * Checks whether login form is valid
	 * @returns true if user may successfully login
	 */
	public boolean userAuthenticate(String user, String pass){
		return true;
	}
	
	/**
	 * Logs in the User
	 * @return true if user was successfully logged in
	 */
	public boolean loginUser(){
		loggedIn = true;
		return true;
	}
	
	/**
	 * Logs out the user
	 * @return true if user was successfully logged out
	 */
	public boolean logoutUser(){
		loggedIn = false;
		return true;
	}
	
	/**
	 * Modifies a User
	 * @param string the data for modification
	 * @return true if modification was successful
	 */
	public boolean editUser(String[] string){
		//stub
		return true;
	}
	
	/**
	 * Deletes this User
	 * @return true if user was successfully deleted
	 */
	public boolean deleteUser(){
		return true;
	}
	
	/**
	 * Creates a User, filling their information fields
	 * @param string array containing fields as indices
	 * @return true if User was successfully created
	 */
	public boolean createUser(String[] string){
		this.username = string[0];
		this.password = string[1];
		
		return true;
	}
}
