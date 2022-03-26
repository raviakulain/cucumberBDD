package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DriverUtils
{
    public void navigateToUrl(String url)
    {
        DriverFactory.driver.navigate().to(url);
    }

    public String getPageTitle()
    {
        return DriverFactory.driver.getTitle();
    }

    public void selectByIndex(WebElement element, int i)
    {
     Select s = new Select(element);
     s.selectByIndex(i);
    }
    public void selectByValue(WebElement element,String val)
    {
        Select s = new Select(element);
        s.selectByValue(val);
    }
    public void selectByVisibleText(WebElement element,String t)
    {
        Select s = new Select(element);
        s.selectByVisibleText(t);
    }
}
