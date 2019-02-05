package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarClass {

    WebDriver driver;

    public CalendarClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath =  "//div[@aria-label='Move backward to switch to the previous month.']") private WebElement arrowLeft;
    @FindBy(xpath = "//div[@aria-label='Move forward to switch to the next month.']")private WebElement arrowRight;

    public void calendar(String monthYear_1, String day_1, String monthYear_2, String day_2) throws InterruptedException {

            List<WebElement> mmyyyyList_1 = driver.findElements(By.xpath("//div[@data-visible='true']//div[.='" + monthYear_1 + "']"));
            for (; mmyyyyList_1.size() < 1; ) {
                driver.findElement(By.xpath("//div[@aria-label='Move backward to switch to the previous month.']")).click();
                mmyyyyList_1 = driver.findElements(By.xpath("//div[@data-visible='true']//div[.='" + monthYear_1 + "']"));
            }
            WebElement dd_1 = driver.findElement(By.xpath("//div[@data-visible='true']//div[.='" + monthYear_1 + "']/..//td[.='" + day_1 + "']"));
            Thread.sleep(200);
            dd_1.click();
            List<WebElement> mmyyyyList_2 = driver.findElements(By.xpath("//div[@data-visible='true']//div[.='" + monthYear_2 + "']"));
            for (; mmyyyyList_2.size() < 1; ) {
                driver.findElement(By.xpath("//div[@aria-label='Move forward to switch to the next month.']")).click();
                mmyyyyList_2 = driver.findElements(By.xpath("//div[@data-visible='true']//div[.='" + monthYear_2 + "']"));
            }
            WebElement dd_2 = driver.findElement(By.xpath("//div[@data-visible='true']//div[.='" + monthYear_2 + "']/..//td[.='" + day_2 + "']"));
            dd_2.click();
            Thread.sleep(200);
        }
    }






