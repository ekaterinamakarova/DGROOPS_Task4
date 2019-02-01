package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

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

    public Boolean waitInvisible(String locator){
        return getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }


    public void implicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(7,SECONDS);
    }


    public Wait<WebDriver> getWebDriverWait() {
        return (Wait<WebDriver>) new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(250, MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void scrollToElement(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void sendKeys(WebElement element, String string){
        element.sendKeys(string);
    }

    public void chooseFromList(WebElement cathegory,WebElement element) throws InterruptedException {
        cathegory.click();
        Thread.sleep(500);
        element.click();

    }

    public static String randomNumber(int count) {
        String digitString = "0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*digitString.length());
            builder.append(digitString.charAt(character));
        }
        return builder.toString();
    }

    public static String randomAlpha(int count) {
        String   alpha_digit= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*alpha_digit.length());
            builder.append(alpha_digit.charAt(character));
        }
        return builder.toString();
    }

    public void assertText(String expected, String actual){
        Assert.assertEquals(expected,actual);
    }

    public void assertDisplay(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }





}
