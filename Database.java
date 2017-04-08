import java.util.ArrayList;
import java.util.HashMap;

/**
 * Database that keeps track of Users as well as pending reports
 * @author User
 *
 */
public class Database {

	private HashMap<String, UserAccount> table;
	private ArrayList<Report> reportList;

	/**
	 * Constructs the Database with a HashMap of Accounts with IDs
	 * as well as a list of Reports
	 */
	public Database(){
		
		table = new HashMap<String, UserAccount>();
		reportList = new ArrayList<Report>();
	}
	
	/**
	 * Ranks the Reports based on priority
	 */
	public void rankReports(){
		
		
	}
	
	/**
	 * Adds a User to the database
	 * @param user to be added
	 * @return true if User was successfully added
	 */
	public boolean addUser(UserAccount user){
		table.put(user.username, user);
		return true;
	}
	
	/**
	 * Adds a Report to the database
	 * @param report to be added
	 * @return true if Report was successfully added
	 */
	public boolean addReport(Report report){
		reportList.add(report);
		return true;
	}

}
