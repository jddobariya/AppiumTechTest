@Wallet
Feature: Create Wallet
	As a app user
	I would like to create wallet with various options 
	So I can make sure all user journeys works correctly.

	@CreateWallet
  Scenario: Create a new wallet without backup successfully
    Given I have clicked on Get Started
    When I click on Create Wallet
    And I skip the Backup option
    And I provide the passcode as "121212"
    And I confirm the passcode as "121212"
    Then app returns successfully with message "Welcome aboard"
    
	@CreateWallet
  Scenario: Create a new wallet returns error on different passcodes
    Given I have clicked on Get Started
    When I click on Create Wallet
    And I skip the Backup option
    And I provide the passcode as "121212"
    And I confirm the passcode as "345612"
    Then app returns successfully with message "Those passwords didn’t match!"

	@CreateWallet
  Scenario: Create a new wallet with manual backup successfully
    Given I have clicked on Get Started
    When I click on Create Wallet
    And I click on Backup Manually option
    And I select all important terms of secret phase
    And I click on Continue
    And I pass the secret phase journey successfully
    And I provide the passcode as "121212"
    And I confirm the passcode as "121212"
    Then app returns successfully with message "Welcome aboard"

  @CreateWallet
  Scenario: Create a new wallet with secret phase error validation
    Given I have clicked on Get Started
    When I click on Create Wallet
    And I click on Backup Manually option
    And I select all important terms of secret phase
    And I click on Continue
    And I fail the secret phase journey
    Then app returns successfully with message "Try again"
    
  @skip_scenario @CreateWallet
  Scenario: Create a new wallet with google drive backup successfully
    Given I have clicked on Get Started
    When I click on Create Wallet
    And I click on Backup up to Google drive option
    And I set the back up name
    And I click on Continue
    And I pass google login journey successfully
    And I provide the passcode as "121212"
    And I confirm the passcode as "121212"
    Then app returns successfully with message "Welcome aboard"
