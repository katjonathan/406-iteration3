import java.util.ArrayList;

/**
 * A UserAccount represents a User (a citizen) that is utilizing
 * the CYPRESS system to submit Reports
 * *********************************************************************************
 * NOTE:
 * Since the majority of these methods pass around packages of data, the most
 * convenient data structure to contain these packages would be a string array.
 * However, to keep the structure of these arrays consistent across all functions,
 * we will use the following format:
 *   Each array will be a 5-tuple, of which the indexes are as follows:
 *      1. username
 *      2. password
 *      3. telephone number
 *      4. address of user
 *      5. email of user
 * When a value for a certain index is not required/not given, it will remain null.
 * *********************************************************************************
 */
public class UserAccount {

    private String username;
    private String password;
    private String telenum;
    private String address;
    private String email;
    private boolean loggedIn;
    private ArrayList<Report> reports;

    /**
     * Constructs an empty UserAccount
     */
    public UserAccount(){
        username = "";
        password = "";
        telenum = "";
        address = "";
        email = "";
		loggedIn = true;
    }
    
    /**
     * Optional: overloaded constructor for
     * class instantiation, mainly for debug purposes
     * 0- username
     * 1- password
     * 2- telenum
     * 3- address
     * 4- email
     */
    public UserAccount(String[] details){
        username = details[0];
        password = details[1];
        telenum = details[2];
        address = details[3];
        email = details[4];
        loggedIn = true;
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
     * Sets the telephone number of the user
     * @param phoneNumber the User's telephone number
     */
    public boolean setTeleNumber(String phoneNumber){
        this.telenum = phoneNumber;
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
     * Gets the user's telephone number
     * @return the telephone Number
     */
    public String getTeleNum(){
        return telenum;
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
     * Checks whether login form is valid
     * @returns true if user may successfully login
     */
    public boolean userAuthenticate(String user, String pass){
        return this.username == user && this.password == pass;
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
     *  0- username
     *  1- password
     *  2- telenum
     *  3- address
     *  4- email
     * @return true if modification was successful
     */
    public boolean editUser(String[] detail){
        if (detail[0] != ""){
            this.username = detail[0];
        }
        if (detail[1] != ""){
            this.password = detail[1];
        }
        if (detail[2] != ""){
            this.telenum = detail[2];
        }
        if (detail[3] != ""){
            this.address = detail[3];
        }
        if (detail[4] != ""){
            this.email = detail[4];
        }
        
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
        this.telenum =  string[2];
        this.address =  string[3];
        this.email =    string[4];
        return true;
    }
    

    /**
     * Checks if the entered username is valid
     * @param database to check name against
     * @param name to have validity checked
     * @return true is username is valid else false
     */

    public boolean checkValidName(String name){
            if(name.equals("") || name.matches("^( )*$"))
				return false;
			else
				return true;
    }

    /**
     * Checks if the entered password is valid
     * @return true if password is valid else false
     */

    public boolean checkValidPass(String pass){
		if(pass.equals(""))
		{
			return false;
		}
		else
		{
			return true;
		}		
    }
    
	/**
	 * Returns a string representation of UserAccount
	 * Used primarily for debugging
	 * @return a string representation of UserAccount object
	*/
	public String toString()
	{
		return new String("USERNAME:  "+username+
						"\nPASSWORD:  "+password+
						"\nTELEPHONE:  "+telenum+
						"\nADDRESS:  "+address+
						"\nEMAIL:  "+email+"\n");
	}
}