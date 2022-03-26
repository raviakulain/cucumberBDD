package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import utils.DriverFactory;
import utils.DriverUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class BasePage
{

    public static HomePage homePage;
    public static RegisterPage registerPage;
    public static LoginPage loginPage;
    public static DriverUtils driverUtils;

    public static void initPages()
    {
        homePage = new HomePage(DriverFactory.driver);
        registerPage = new RegisterPage(DriverFactory.driver);
        loginPage = new LoginPage(DriverFactory.driver);
        driverUtils= new DriverUtils();

    }

}
