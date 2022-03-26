Feature: Register new user

  Background: navigate to url and goto register page
    Given i am on the home page of nop commerce
    Then i will be navigated to home page
    When i click on register link on the navbar
    Then  i will be navigated to register page
  @ui
  Scenario:Verify user registration by providing data in mandatory fields
    When i select gender as male
    And i enter firstName lastName email password confPassword

      | firstName| lastName| email| password |confPassword|
      | user| qa| user18@nop.com| Testing@123 |Testing@123|
    And i select day month year
    And i click on register button
    Then i should see the register confirmation message

  @regression
  Scenario: Verify user registration by not provided data in mandatory fields
    When i click on register button

    Then i should see error message for the missing mandatory fields