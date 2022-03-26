Feature: Login to nop commerce
  In order to login to application
  As a user
  I should provide credentials

  @regression
  Scenario: verify login with valid credentials
    Given i am on the home page of nop commerce
    Then i will be navigated to home page
    When i click on login link on navbar
    Then i will be navigated to login page
    When i enter email as "user18@nop.com"
    And i enter password as "Testing@123"
    And i click on login button
    Then i should be logged in successfully
