package cucumber.demo;

import java.util.ArrayList;
import java.util.List;

public interface AdresseService {
	public List<UserContract> contracts = new ArrayList<>();
	public void updateUserContract(String adresse);
	public List<UserContract> getUserContracts(long l);
	public void updateAddress();
}
