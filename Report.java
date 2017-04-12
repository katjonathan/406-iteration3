/**
 * A Report is created and submitted to the CYPRESS system by users (citizens)
 * and contains information regarding location and nature of the complaint
 */
public class Report {

	private String owner;
	private String address;
	private String concern;
	private String reportCode;
	
	/**
	 * Constructs a report with given
	 */
	public Report(String[] data){
            concern = data[0];
            address = data[1];
            owner = data[2];
            reportCode = createReportCode();
	}
	
	/**
	 * Generates a reportCode for the Report
         * A report code is generated as follows:
         *  AAA_BBB
         * Where,
         *  AAA represents the hashcode of the concern type, and
         *  BBB represents the hashcode of the address type, and
         * 
         * This method aims to achieve the following:
         * -Every report has its own code
         * -Two equal reports have the same code
         * -Two different reports will not have the same code
	 * @return true if reportCode was successfully generated
	 */
	private String createReportCode(){
            String productConcern = Integer.toString(this.concern.hashCode());
            String productAddress = Integer.toString(this.address.hashCode());
            return productConcern + "_" + productAddress;
	}
	
	/**
	 * Edits the Report with the given info
	 * @param string array containing data fields as indices
         * 0- contains the concern
         * 1- contains the address
         * If any of these values are not given, they will be null
	 * @return true if edit was successful
	 */
	public boolean editReport(String[] data){
            if(data[0] != null){
                this.concern = data[0];
            }
            if(data[1] != null){
                this.address = data[1];
            }
            this.reportCode = createReportCode();
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
        
        /**
         * Gets the report code
         * @return report code
         */
        String getReportID(){
            return reportCode;
        }
}