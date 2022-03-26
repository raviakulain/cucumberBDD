package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;
    @FindBy(linkText = "Register")                     //webElement/locators
    public WebElement registerLink;
    @FindBy(linkText = "Log in")
    public WebElement loginLink;
    @FindBy(id="small-searchterms")
    public WebElement searchTextBox;
    @FindBy(className = "search-box-button")
    public WebElement searchBtn;

    @FindBy(className = "ico-logout")
    public WebElement logoutLink;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickRegisterLink()                       //Actions
    {
        registerLink.click();
    }
    public void clickLoginLink()
    {
        loginLink.click();
    }
    public void enterSearchText(String product)
    {
        searchTextBox.sendKeys(product);
    }
    public void clickSearchButton()
    {
        searchBtn.click();
    }
    public boolean verifyLogout()
    {
        return logoutLink.isDisplayed();
    }
}
