package cucumber.demo;

public class UserContract {
	  private long contractId; 
	  private String userName;
	  private int contractNumber;
      private String contractAdresse;
      
     public UserContract(long id,String name,int nbr,String adre) {
    	 this.contractId = id;
    	 this.setUserName(name);
    	 this.setContractNumber(nbr);
    	 this.setContractAdresse(adre);
     }
	public String getAddresse() {
		return "adresse";
	}
	public long getId() {
		return this.contractId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getContractAdresse() {
		return contractAdresse;
	}
	public void setContractAdresse(String contractAdresse) {
		this.contractAdresse = contractAdresse;
	}
}
