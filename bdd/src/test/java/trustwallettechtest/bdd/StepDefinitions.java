package trustwallettechtest.bdd;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import io.cucumber.java.en.*;
import trustwallettechtest.bdd.Pages.HomePage;

public class StepDefinitions {

	private HomePage homePage = new HomePage();
	@Given("I have clicked on Get Started")
	public void iHaveClickedOnGetStartedButton() {
		homePage.ClickGetStartedBtn();
	}

	@When("I click on Create Wallet")
	public void iClickOnCreateWalletButton() {
		homePage.ClickCreateWalletBtn();;
	}

	@When("I skip the Backup option")
	public void iSkipTheBackupOption() {
		homePage.ClickSkipBackup();
	}

	@When("I click on Backup Manually option")
	public void iClickTheBackupOption() {
		homePage.ClickBackupManually();
	}

	@When("I provide the passcode as {string}")
	public void iProvideThePasscodeAs(String passcode) 
	{
		for(String codeNumber : passcode.replace("'", "").split("(?!^)"))
		{
			homePage.ClickNumber(codeNumber);
		}
	}

	@When("I confirm the passcode as {string}")
	public void iConfirmThePasscodeAs(String passcode) 
	{
		iProvideThePasscodeAs(passcode);
	}

	@Then("app returns successfully with message {string}")
	public void appRetrnsSuccessfullyWithMessage(String message) 
	{
		List<String> messages = homePage.GetAllWidgetTextStrings(message);
		assertThat(messages,hasItems(message));
	}

	@When("I select all important terms of secret phase")
	public void i_select_all_important_terms_of_secret_phase() {
		homePage.SelectAllAcceptImportanceOfSecret();
	}

	@When("I click on Continue")
	public void i_click_on_continue() {
		homePage.ClickContinueBtn();
	}

	@When("I pass the secret phase journey successfully")
	public void i_pass_the_secret_phase_journey_successfully() {
		homePage.SelectSecretPhaseKeys(true);
	}

	@When("I fail the secret phase journey")
	public void i_fail_the_secret_phase_journey() {
		homePage.SelectSecretPhaseKeys(false);
	}


	@When("I click on Backup up to Google drive option")
	public void i_click_on_backup_up_to_google_drive_option() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I set the back up name")
	public void i_set_the_back_up_name() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I pass google login journey successfully")
	public void i_pass_google_login_journey_successfully() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}


}
