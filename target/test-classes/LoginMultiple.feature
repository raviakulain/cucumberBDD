Feature: Login to nop commerce
  In order to login to application
  As a user
  I should provide credentials

  @sanity
  Scenario Outline: verify login with valid credentials
    Given i am on the home page of nop commerce
    Then i will be navigated to home page
    When i click on login link on navbar
    Then i will be navigated to login page
    When i enter email as "<email>"
    And i enter password as "<password>"
    And i click on login button
    Then i should be logged in successfully

    Examples:
      | email         | password    |
      | user23@nop.com | Testing@123 |
      | user24@nop.com | Testing@123 |
      | user25@nop.com | Testing@123 |