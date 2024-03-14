@Crypto
Feature: Manage Crypto

  @skip_scenario @ManageCrypto
  Scenario: Toggle Crypto On and Off 
    Given I have created a wallet
    And I click on Manage Crypto option
    When I click on toggle on for "BTC" crypto
    Then the toggle is turned on successfully
    When I click on toggle off for "BTC crypto
    Then the toggle is turned off successfully
    
  @skip_scenario @ManageCrypto
  Scenario Outline: Search Crypto on manage crypto page
    Given I have created a wallet
    And I click on Manage Crypto option
    When I search for 'A' crypto in the filter
    Then the results returned should contain 'A'
    
    Examples:
    | FilterText|
    | A         |
    | a         |
    | BTC       |
    
  @skip_scenario @ManageCrypto 
  Scenario: Search Crypto By a particular network
    Given I have created a wallet
    And I click on Manage Crypto option
    When I select 'Ethereum' network
    Then manage crypto page should display Etherum as selected
    When I search for 'BTC' crypto in the filter
    Then the results returned should contain 'BTC'
    And the crypto name should have 'Ethereum' network displayed
    
  @skip_scenario @ManageCrypto
  Scenario: Import Crypto via the plus sign and type set as token
    Given I have created a wallet
    And I click on Manage Crypto option
    When I click on add option
    And I select the type as "Token"
    And I select the network as "Ethereum"
    And I provide the address as "ABC"
    And I provide the name as "TestToken"
    And I provide the symbol as "$"
    And I provide the decimals value as "123124"
    When I click on import
    Then the crypto sould be imported successfully
    
  @skip_scenario @ManageCrypto
  Scenario: Import Crypto via the plus sign and type set as network
    Given I have created a wallet
    And I click on Manage Crypto option
    When I click on add option
    And I select the type as "Network"
    And I select the network as "Ethereum"
    And I select the profile as  'HARMONY'
    When I click on import
    Then the crypto sould be imported successfully
    
   @skip_scenario @ManageCrypto
   Scenario: Import Crypto page is loaded successfully via search
    Given I have created a wallet
    And I click on Manage Crypto option
    When I search for 'ABCDEFG' crypto in the filter
    And I click on the didnt see your crypto import link
    Then the import page is loaded successfully