package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main {

    @FindBy (css = "div[id='Create Group']") private WebElement createGroupBtn;

    WebDriver driver;
    public Main(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void toCreateGroupPage() throws InterruptedException {
        HelperClass helper = new HelperClass(driver);
        helper.waitForClikable(createGroupBtn);
        createGroupBtn.click();
    }


}
