/**
 * A Report is created and submitted to the CYPRESS system by users (citizens)
 * and contains information regarding location and nature of the complaint
 * @author User
 *
 */
public class Report {

	String owner;
	String address;
	String concern;
	int reportCode;
	
	/**
	 * Constructs an empty Report
	 */
	public Report(){
		owner = "";
		address = "";
		concern = "";
		reportCode = 0;
	}
	
	/**
	 * Generates a reportCode for the Report
	 * @param string
	 * @param database
	 * @return true if reportCode was successfully generated
	 */
	public boolean createReportCode(String[] string, Database database){
		
		return true;
	}
	
	/**
	 * Edits the Report with the given info
	 * @param string array containing data fields as indices
	 * @return true if edit was successful
	 */
	public boolean editReport(String[] string){
		
		return true;
	}
	
	/**
	 * Deletes the Report
	 * @return true if Report was successfully deleted
	 */
	public boolean deleteReport(){
		
		return true;
	}
	
	/**
	 * Sets the owner of the Report
	 * @param owner of the report
	 */
	void setOwner(String owner){
		this.owner = owner;
	}
	
	/**
	 * Sets the address of the Report
	 * @param address of the Report
	 */
	void setAddress(String address){
		this.address = address;
	}
	
	/**
	 * Sets the concern of the Report
	 * @param concern of the report
	 */
	void setConcern(String concern){
		this.concern = concern;
	}
	
	/**
	 * Gets the Report's Owner
	 * @return owner of the Report
	 */
	String getOwner(){
		return owner;
	}
	
	/**
	 * Gets the Report's Address
	 * @return address of the Report
	 */
	String getAddress(){
		return address;
	}
	
	/**
	 * Gets the Report's Concern
	 * @return concern of the Report
	 */
	String getConcern(){
		return concern;
	}
}
