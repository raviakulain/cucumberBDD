package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverFactory;

public class RegisterPage
{
    WebDriver driver;

    @FindBy(id="FirstName")
    public WebElement firstNameTextBox;

    @FindBy(id="LastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "Email")
    public WebElement emailTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "ConfirmPassword")
    public WebElement confPasswordTextBox;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    @FindBy(name="DateOfBirthDay")
    public WebElement dayDropDown;

    @FindBy(className = "result")
    public WebElement regConfText;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthDropDown;

    @FindBy(name = "DateOfBirthYear")
    public WebElement yearDropDown;

    @FindBy(id = "gender-male")
    public WebElement maleRadioBtn;

    @FindBy(id = "FirstName-error")
    public WebElement firstNameErrorMsg;

    @FindBy(id = "LastName-error")
    public WebElement lastNameErrorMsg;

    @FindBy(id = "Email-error")
    public WebElement emailErrorMsg;

    @FindBy(id = "Password-error")
    public WebElement passwordErrorMsg;

    @FindBy(id="ConfirmPassword-error")
    public WebElement confPasswordErrorMsg;


    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void enterFirstName(String f)
    {
        firstNameTextBox.sendKeys(f);
    }

    public void enterLastName(String ln)
    {
        lastNameTextBox.sendKeys(ln);
    }
    public void enterEmail(String em)
    {
        emailTextBox.sendKeys(em);
    }
    public void enterPassword(String pw)
    {
        passwordTextBox.sendKeys(pw);
    }
    public void enterConfPassword(String cpw)
    {
        confPasswordTextBox.sendKeys(cpw);
    }
    public void clickRegisterButton()
    {
        registerButton.click();
    }

    public void selectDayValue(String day)
    {
        BasePage.driverUtils.selectByVisibleText(dayDropDown,day);
    }
    public void selectMonthValue(String month)
    {
        BasePage.driverUtils.selectByValue(monthDropDown,month);
    }
    public void selectYearValue(String v)
    {
        BasePage.driverUtils.selectByValue(yearDropDown,v);
    }

    public void clickMaleRadioBtn()
    {
        maleRadioBtn.click();
    }


    public String getConfText()
    {
        return regConfText.getText();
    }

    public String getFirstnameErrorText()
    {
        return firstNameErrorMsg.getText();
    }

    public String getLastnameErrorText()
    {
        return lastNameErrorMsg.getText();
    }

    public String getEmailErrorText()
    {
        return emailErrorMsg.getText();
    }

    public String getPasswordErrorMsg()
    {
        return passwordErrorMsg.getText();
    }
    public String getConfPasswordErrorMsg()
    {
        return confPasswordErrorMsg.getText();
    }

}
