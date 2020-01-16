package cucumber.demo;

public class Conseiller {
	private int id;
	private String name;
	private String loginCompte;
	
	public Conseiller(String compteType) {
		super();
		this.loginCompte = compteType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompteType() {
		return loginCompte;
	}
	public void setCompteType(String compteType) {
		this.loginCompte = compteType;
	}
}
