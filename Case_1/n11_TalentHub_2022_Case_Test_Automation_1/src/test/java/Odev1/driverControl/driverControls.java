package Odev1.driverControl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;

public class driverControls {
    static ChromeOptions optionsch;
    static FirefoxOptions optionsfi;
    static EdgeOptions optionsed;
    static OperaOptions optionsop;

    public static WebDriver driverControl(WebDriver driver, String driverName) {
        if (Objects.equals(driverName, "Chrome")) {
            chromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(optionsch);
        } else if (Objects.equals(driverName, "Firefox")) {
            firefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(optionsfi);

        } else if (Objects.equals(driverName, "Safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            //SafariNotSupportedHeadless
        } else if (Objects.equals(driverName, "Opera")) {
            operaOptions();
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver(optionsop);

        } else if (Objects.equals(driverName, "Edge")) {
            edgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(optionsed);

        } else System.out.println("Driver range out of test.");
        return driver;
    }
    static void chromeOptions(){
        optionsch = new ChromeOptions();
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.verboseLogging", "false");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        optionsch.addArguments("--headless");
        optionsch.addArguments("--no-sandbox");
        optionsch.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        optionsch.addArguments("disable-infobars"); // disabling infobars
        optionsch.addArguments("--disable-extensions"); // disabling extensions
        optionsch.addArguments("--disable-gpu"); // applicable to windows os only
        optionsch.addArguments("window-size=1024,1024"); // Bypass OS security model
        optionsch.addArguments("dom.ipc.processCount", "1");
        optionsch.addArguments("security.sandbox.content.level", "5");
        optionsch.addArguments("--disable-notifications");
    }
    static void firefoxOptions(){
        optionsfi = new FirefoxOptions();
        System.setProperty("webdriver.gecko.args", "--disable-logging");
        System.setProperty("webdriver.gecko.silentOutput", "true");
        optionsfi.addArguments("--headless");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
    }
    static void edgeOptions(){
        optionsed = new EdgeOptions();
        System.setProperty("webdriver.edge.args", "--disable-logging");
        System.setProperty("webdriver.edge.silentOutput", "true");
        optionsed.addArguments("--headless");
        optionsed.addArguments("--no-sandbox");
        optionsed.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        optionsed.addArguments("disable-infobars"); // disabling infobars
        optionsed.addArguments("--disable-extensions"); // disabling extensions
        optionsed.addArguments("--disable-gpu"); // applicable to windows os only
        optionsed.addArguments("--width=1024"); // Bypass OS security model 1920*1080
        optionsed.addArguments("--height=768");
        optionsch.addArguments("dom.ipc.processCount", "1");
        optionsch.addArguments("security.sandbox.content.level", "5");
        optionsch.addArguments("--disable-notifications");
    }
    static void operaOptions(){
        optionsop = new OperaOptions();
        System.setProperty("webdriver.opera.args", "--disable-logging");
        System.setProperty("webdriver.opera.silentOutput", "true");
        optionsop.addArguments("--headless");
        optionsop.addArguments("--no-sandbox");
        optionsop.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        optionsop.addArguments("disable-infobars"); // disabling infobars
        optionsop.addArguments("--disable-extensions"); // disabling extensions
        optionsop.addArguments("--disable-gpu"); // applicable to windows os only
        optionsop.addArguments("--width=1024"); // Bypass OS security model 1920*1080
        optionsop.addArguments("--height=768");
        optionsop.addArguments("dom.ipc.processCount", "1");
        optionsop.addArguments("security.sandbox.content.level", "5");
        optionsop.addArguments("--disable-notifications");
    }
}
