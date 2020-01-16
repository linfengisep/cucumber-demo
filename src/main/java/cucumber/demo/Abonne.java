package cucumber.demo;

public class Abonne {
	private String adresse;
	private String userName;
	private int userId;
	private int numberContract;
	
	public Abonne() {}
	
	public Abonne(String adresse, String userName, int userId, int numberContract) {
		super();
		this.adresse = adresse;
		this.userName = userName;
		this.userId = userId;
		this.numberContract = numberContract;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNumberContract() {
		return numberContract;
	}

	public void setNumberContract(int numberContract) {
		this.numberContract = numberContract;
	}

	public String getAdresse() {
		return adresse;
	}

    public void setAdresse(String adresse) {
    	this.adresse = adresse;
    }
    
    public int getId() {
    	return this.userId;
    }
}
