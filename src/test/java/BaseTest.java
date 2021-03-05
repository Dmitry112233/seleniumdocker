import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.GooglePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    private int timeout = 3;

    protected GooglePage googlePage;

    public WebDriver getDriver() {
        return driver;
    }

    public void configureBrowser() throws MalformedURLException {

        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else {
            dc = DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        String completeUrl = "http://" + host + ":4444/wd/hub";
        System.out.println(host);
        /*ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", PropertyReader.getInstance().get("chromedriver"));*/
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void init() throws MalformedURLException {
        configureBrowser();
        this.googlePage = new GooglePage(driver);
    }

    @AfterMethod
    public void quitBrowser() {
        if (null != this.driver) {
            this.driver.quit();
            this.driver = null;
        }
    }
}