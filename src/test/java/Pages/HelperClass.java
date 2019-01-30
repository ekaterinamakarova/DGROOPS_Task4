package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HelperClass {

    WebDriver driver;
    public HelperClass(WebDriver driver){
        this.driver=driver;
    }

    public WebElement waitForClikable(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForStaleness(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.stalenessOf(element));
    }


    public void implicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5,SECONDS);
    }


    public Wait<WebDriver> getWebDriverWait() {
        return (Wait<WebDriver>) new FluentWait<>(driver)
                .withTimeout(15, SECONDS)
                .pollingEvery(250, MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public void sendKeys(List<WebElement> element, int i, String string){
        element.get(i).sendKeys(string);
    }

    public void chooseFromList(List<WebElement> element1, int i,WebElement element2){
        element1.get(i).click();
        element2.click();

    }
}
