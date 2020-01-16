package io.cucumber.skeleton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import org.mockito.Mockito;

import cucumber.demo.Abonne;
import cucumber.demo.AdresseService;
import cucumber.demo.AdresseServiceImpl;
import cucumber.demo.Mouvement;
import cucumber.demo.MouvementService;
import cucumber.demo.MouvementServiceImpl;
import cucumber.demo.UserContract;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources")
public class StepDefinitions {
	private static final String DEFAULT_ADDRESS = "4 Rue de la paix, 75006 Paris";
	private static final String EXPECTED_ADDRESS = "4 Rue de la passerelle, 78600 Maisons-Laffitte";
	  
    private AdresseService adresseService = new AdresseServiceImpl();
    private MouvementService mouvementService = new MouvementServiceImpl();
    private Abonne abonne;
    private List<UserContract> userContracts = new ArrayList<>();
    private List<Mouvement> mouvements = new ArrayList<>();
	 
	@Given("un abonné avec une adresse principale en France")
	public void abonne_avec_adresse_principale() throws Throwable {
		abonne = new Abonne(DEFAULT_ADDRESS,"Jet Li",1,21);
	}
	
	@When("le conseiller connecté à {word} modifie l'adresse de l'abonné")
	public void conseiller_modifie_adresse_abonne(String canal) throws Throwable {
		assertEquals(canal,"canal");
		
		abonne.setAdresse(EXPECTED_ADDRESS);
		
		//mocking AdresseService;
	    userContracts.add(new UserContract(1, "Jet Li",21,DEFAULT_ADDRESS));
	    userContracts.add(new UserContract(2, "Bruce", 22, DEFAULT_ADDRESS));
	    userContracts.add(new UserContract(3, "François", 23, DEFAULT_ADDRESS));
	    when(adresseService.getUserContracts(Mockito.anyLong())).thenReturn(userContracts.subList(0, 2));
		
		//mocking MouvementService;
	    mouvements.add(new Mouvement(1,"update_address"));
	    when(mouvementService.getMouvements()).thenReturn(mouvements);
	}
	
	@Then("l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné")
	public void adresse_modifiee_est_sauvegardé_sur_ensemble_des_contrats() {
		
		adresseService.updateUserContract(EXPECTED_ADDRESS);
		userContracts = adresseService.getUserContracts(abonne.getId());
		
		for (UserContract contract: userContracts) {
			assertEquals(contract.getAddresse(), DEFAULT_ADDRESS);
		}
	}
	
	@And("un mouvement de modification d'adresse est créé")
	public void un_mouvement_modification_adresse_est_cree() {
		assertEquals(mouvementService.getMouvements().size(), 1);
	}
}
