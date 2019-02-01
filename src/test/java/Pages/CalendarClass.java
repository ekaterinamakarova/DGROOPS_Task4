package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarClass {

    WebDriver driver;

    public CalendarClass(WebDriver driver) {
        this.driver = driver;
    }

    HelperClass helper= new HelperClass(driver);

    public void calendar(WebElement title, String value, WebElement nextBtn, List<WebElement> cells, String digit) throws InterruptedException {
        monthTitle(title, value, nextBtn);
        necessaryDate(cells, digit);

    }

    public void monthTitle(WebElement title, String value, WebElement nextBtn) {

        do {
            if (title.getText() == value) {
                System.out.println("OK");
            } else nextBtn.click();
        }
        while (title.getText() == value);
    }


    public void necessaryDate(List<WebElement> cells, String digit) throws InterruptedException {
        int k=0;
        do {
            if (cells.get(k).getText() == digit) {
                cells.get(k).click();
                Thread.sleep(1000);
            }
            else k=+1;
        }
        while (cells.get(k).getText() == digit);


    }
}



