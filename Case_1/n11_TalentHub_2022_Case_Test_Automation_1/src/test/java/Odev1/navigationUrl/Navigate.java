package Odev1.navigationUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Navigate {
    WebDriver driver;
    public Navigate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void openN11HomePage(String url){
        driver.get(url);
    }
}
