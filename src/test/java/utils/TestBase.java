package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TestBase {
    public WebDriver driver;


    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("url");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven!=null ? browser_maven : browser_properties;

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\PaviData\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {

            }
            driver.get(url);
        }
        return driver;
    }

}
