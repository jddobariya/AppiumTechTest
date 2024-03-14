@Wallet
Feature: Add Existing Wallet

  @skip_scenario @CreateWallet
  Scenario Outline: Create a existing wallet with secret phase 
    Given I have clicked on Get Started
    When I click on Add Existing Wallet
    And I click on Secret Phase option
    And I select the network as "<Network>"
    And I provide secret phase from clipboard
    And I click on Continue
    And I provide the passcode as "121212"
    And I confirm the passcode as "121212"
    Then app returns successfully with message "Welcome aboard"
    
    Examples:
    |Id| Network          |
		|01| Multi-coin wallet|
		|02| Bitcoin          |
	
	@skip_scenario @CreateWallet	
	Scenario: Create a existing wallet with google drive backup
    Given I have clicked on Get Started
    When I click on Add Existing Wallet
    And I click on Google Drive backup option
    And I pass the google login journey
    And I click on Continue
    And I provide the passcode as "121212"
    And I confirm the passcode as "121212"
    Then app returns successfully with message "Welcome aboard"
   
  @skip_scenario @CreateWallet 
  Scenario: Create a view only wallet 
    Given I have clicked on Get Started
    When I click on Add Existing Wallet
    And I click on View only wallet option
    And I select the network as "Etherum"
    And I add the address or domain name
    And I click on Continue
    And I provide the passcode as "121212"
    And I confirm the passcode as "121212"
    Then app returns successfully with message "Welcome aboard"
  
  @skip_scenario @CreateWallet  
  Scenario: Create a view only wallet with scan 
    Given I have clicked on Get Started
    When I click on Add Existing Wallet
    And I click on View only wallet option
    And I select the network as "Etherum"
    And I add the address or domain name
    And I click on Continue
    And I provide the passcode as "121212"
    And I confirm the passcode as "121212"
    Then app returns successfully with message "Welcome aboard"

		
