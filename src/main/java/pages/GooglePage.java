package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.sql.Driver;

public class GooglePage {

    WebDriver driver;

    public GooglePage(WebDriver driver){
        this.driver = driver;
    }

    private By logo = new By.ById("hplogo");

    public void OpenPage(){
        driver.get(PropertyReader.getInstance().get("url.path.google.main"));
         new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(logo)));
    }

    public String GetLogoAtributeAlt(){
        return driver.findElement(logo).getAttribute("alt");
    }
}
