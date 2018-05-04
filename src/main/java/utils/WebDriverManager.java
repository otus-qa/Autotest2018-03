package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {

    private static final String WEBDRIVER_SETTINGS_ADDRESS = "properties/settings.properties";
    private static final String PROXY_ADDRESS = PropertyReader.getPropertyFromFile(WEBDRIVER_SETTINGS_ADDRESS,
            "proxy");

    private static WebDriver driver;

    public static WebDriver getDriver() {
//        String browserName = "firefox-proxy";
        String browserName = "chrome-remote";

        if (driver == null) {

            switch (browserName) {
                case "chrome": {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                }
                case "chrome-headless": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    break;
                }
                case "chrome-ssl": {
                    ChromeOptions options = new ChromeOptions();
                    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    driver = new ChromeDriver(options);
                    break;
                }
                case "chrome-remote": {
                    try {
                        driver = new RemoteWebDriver(new URL("http://192.168.1.63:20003/wd/hub"),
                                DesiredCapabilities.chrome());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

                }
                case "firefox-proxy": {
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(PROXY_ADDRESS);

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability(CapabilityType.PROXY, proxy);

                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                }

            }

        }
        return driver;
    }
}
