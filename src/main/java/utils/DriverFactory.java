package utils;


import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory
{
    public static WebDriver driver;
    public static Properties prop;
    public static final String AUTOMATE_USERNAME = "raviakula_O2m57u";
    public static final String AUTOMATE_ACCESS_KEY = "4fbArgDycxjexPsTQjQg";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver getDriver() throws MalformedURLException
    {
        prop = new Properties();
        try
        {
            FileInputStream fs = new FileInputStream("src/main/java/config/data.properties");
            prop.load(fs);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       /* WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        */
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "11");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "latest-beta");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "nopCommerce Login"); // test name
        caps.setCapability("build", "Test 1"); // CI/CD job or build name

        driver = new RemoteWebDriver(new URL(URL), caps);

        driver.manage().window().maximize();
        BasePage.initPages();
        return driver;
    }
    public static void closeDriver()
    {
       // driver.quit();
    }
}
