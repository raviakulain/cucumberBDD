package steps;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import utils.DriverFactory;

public class StepDefinitions
{
    String actualHomePageTitle;
    String actualLoginPageTitle;
    String actualRegisterPageTitle;
    String actualRegisterConfMsg;
    String actualFirstNameErrorTextMsg;
    String actualLastNameErrorTextMsg;
    String actualEmailErrorTextMsg;
    String actualPasswordErrorTextMsg;
    String actualConfPasswordErrorTextMsg;

    @Given("i am on the home page of nop commerce")
    public void i_am_on_the_home_page_of_nop_commerce()
    {
        BasePage.driverUtils.navigateToUrl(DriverFactory.prop.getProperty("url"));
    }
    @Then("i will be navigated to home page")
    public void i_will_be_navigated_to_home_page()
    {
        actualHomePageTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(DriverFactory.prop.getProperty("homePageExpectedTitle"),actualHomePageTitle);
    }
    @When("i click on login link on navbar")
    public void i_click_on_login_link_on_navbar()
    {
        BasePage.homePage.clickLoginLink();
    }
    @Then("i will be navigated to login page")
    public void i_will_be_navigated_to_login_page()
    {
        actualLoginPageTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(DriverFactory.prop.getProperty("expectedLoginPageTitle"),actualLoginPageTitle);
    }
    @When("i enter email as {string}")
    public void i_enter_email_as(String email)
    {
        BasePage.loginPage.enterEmail(email);
    }
    @When("i enter password as {string}")
    public void i_enter_password_as(String pwd)
    {
        BasePage.loginPage.enterPassword(pwd);
    }
    @When("i click on login button")
    public void i_click_on_login_button()
    {
        BasePage.loginPage.clickLoginBtn();
    }
    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully()
    {
        Assertions.assertTrue(BasePage.homePage.verifyLogout(),"log out link is displayed");
    }

    @When("i click on register link on the navbar")
    public void i_click_on_register_link_on_the_navbar()
    {
        BasePage.homePage.clickRegisterLink();
    }

    @Then("i will be navigated to register page")
    public void i_will_be_navigated_to_register_page()
    {
        actualRegisterPageTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(DriverFactory.prop.getProperty("registerPageExpectedTitle"),actualRegisterPageTitle);
    }

    @When("i select gender as male")
    public void i_select_gender_as_male()
    {
        BasePage.registerPage.clickMaleRadioBtn();
    }

    @When("i enter firstName lastName email password confPassword")
    public void i_enter_first_name_last_name_email_password_conf_password(io.cucumber.datatable.DataTable dataTable)
    {
        BasePage.registerPage.enterFirstName(dataTable.cell(1,0));
        BasePage.registerPage.enterLastName(dataTable.cell(1,1));
        BasePage.registerPage.enterEmail(dataTable.cell(1,2));
        BasePage.registerPage.enterPassword(dataTable.cell(1,3));
        BasePage.registerPage.enterConfPassword(dataTable.cell(1,4));
    }

    @When("i select day month year")
    public void i_select_day_month_year()
    {
        BasePage.registerPage.selectDayValue(DriverFactory.prop.getProperty("dayValue"));
        BasePage.registerPage.selectMonthValue(DriverFactory.prop.getProperty("month"));
        BasePage.registerPage.selectYearValue(DriverFactory.prop.getProperty("yearValue"));
    }

    @When("i click on register button")
    public void i_click_on_register_button()
    {
        BasePage.registerPage.clickRegisterButton();
    }

    @Then("i should see the register confirmation message")
    public void i_should_see_the_register_confirmation_message()
    {
        actualRegisterConfMsg = BasePage.registerPage.getConfText();
        Assertions.assertEquals(DriverFactory.prop.getProperty("expectedRegisterConfMsg"),actualRegisterConfMsg);
    }
    @Then("i should see error message for the missing mandatory fields")
    public void i_should_see_error_message_for_the_missing_mandatory_fields()
    {

        actualFirstNameErrorTextMsg = BasePage.registerPage.getFirstnameErrorText();
        Assertions.assertEquals(DriverFactory.prop.getProperty("expectedFirstNameErrorText"),actualFirstNameErrorTextMsg);

        actualLastNameErrorTextMsg = BasePage.registerPage.getLastnameErrorText();
        Assertions.assertEquals(DriverFactory.prop.getProperty("expectedLastNameErrorText"),actualLastNameErrorTextMsg);

        actualEmailErrorTextMsg = BasePage.registerPage.getEmailErrorText();
        Assertions.assertEquals(DriverFactory.prop.getProperty("expectedEmailErrorText"),actualEmailErrorTextMsg);

        actualPasswordErrorTextMsg = BasePage.registerPage.getPasswordErrorMsg();
        Assertions.assertEquals(DriverFactory.prop.getProperty("expectedPasswordErrorText"),actualPasswordErrorTextMsg);

        actualConfPasswordErrorTextMsg = BasePage.registerPage.getConfPasswordErrorMsg();
        Assertions.assertEquals(DriverFactory.prop.get("expectedConfPasswordErrorText"),actualConfPasswordErrorTextMsg);
    }
}
